package script.developer;

import script.dictionary;
import script.library.sui;
import script.library.utils;
import script.obj_id;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class object_spawner extends script.base_script
{
    public object_spawner() {}

    private static final String DEFAULT_PATH = "../../dsrc/sku.0/sys.server/compiled/game/";

    private static final String OBJECT_SPAWNER_PROMPT = "Files and Folders are populated below. Select from the listing.";
    private static final String OBJECT_SPAWNER_TITLE = "Object Viewer";
    private static final String BASE_PATH = "object/";

    private String currentPath = BASE_PATH; //Default to object/
    private String[] currentOptions = new String[0];

    public void openObjectViewer(obj_id self) throws InterruptedException
    {
        closeOldWindow(self);
        currentOptions = loadFromPath(self, BASE_PATH);
        sendSystemMessageTestingOnly(self, "currentOptions.length: " + currentOptions.length);

        final int pid = sui.listbox(self, self, OBJECT_SPAWNER_PROMPT, sui.OK_CANCEL, OBJECT_SPAWNER_TITLE, currentOptions, "handleOptionSelect", true, false);
        setWindowPid(self, pid);
    }

    public void handleSubMenuSelect(obj_id self) throws InterruptedException
    {
        closeOldWindow(self);

        final int pid = sui.listbox(self, self, OBJECT_SPAWNER_PROMPT, sui.OK_CANCEL, OBJECT_SPAWNER_TITLE, currentOptions, "handleOptionSelect", true, false);
        setWindowPid(self, pid);
    }

    public int handleOptionSelect(obj_id self, dictionary params) throws InterruptedException
    {

        final int btn = sui.getIntButtonPressed(params);
        final int idx = sui.getListboxSelectedRow(params);

        if (btn == sui.BP_CANCEL)
        {
            cleanScriptVars(self);
            closeOldWindow(self);
            currentPath = BASE_PATH;
            currentOptions = new String[0];
            return SCRIPT_CONTINUE;
        }

        if (currentOptions.length == 0)
        {
            currentOptions = loadFromPath(self, currentPath);
        }

        if (idx < 0 || idx >= currentOptions.length)
        {
            sendSystemMessageTestingOnly(self, "Invalid option selected");
            openObjectViewer(self);
            return SCRIPT_CONTINUE;
        }

        handleSelectedOption(self, idx);
        return SCRIPT_CONTINUE;
    }

    public void handleSelectedOption(obj_id self, int idx) throws InterruptedException
    {
        final String selectedOption = currentOptions[idx];

        if (selectedOption.startsWith("[File] "))
        {
            String fileName = selectedOption.substring("[File] ".length()); // Extracting the file name
            String objectPath = currentPath.substring(fileName.indexOf("object/") + "object/".length());
            objectPath = "object" + objectPath + fileName + ".iff";
            createObject(objectPath, getLocation(self));
            handleSubMenuSelect(self);
        }
        else if (selectedOption.startsWith("[Folder] "))
        {
            String folderName = selectedOption.substring("[Folder] ".length()); // Extracting the folder name
            currentPath += folderName + "/";
            currentOptions = loadFromPath(self, currentPath);
            handleSubMenuSelect(self);
        }
        else
        {
            sendSystemMessageTestingOnly(self, "Invalid option selected");
            openObjectViewer(self);
        }
    }

    public String[] loadFromPath(obj_id self, String path)
    {
        final String fullPath = DEFAULT_PATH + path;
        Path dir = Paths.get(fullPath);
        List<String> fileNames = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir))
        {
            for (Path entry : stream)
            {
                String eName = String.valueOf(entry.getFileName());
                if (Files.isDirectory(entry))
                {
                    fileNames.add("[Folder] " +eName);
                }
                else
                {
                    // Stripping file extension for files
                    int extensionIndex = eName.lastIndexOf('.');
                    if (extensionIndex > 0) {
                        eName = eName.substring(0, extensionIndex);
                    }
                    fileNames.add("[File] " + eName);
                }
            }
            Collections.sort(fileNames);
        }
        catch (IOException e)
        {
            sendSystemMessageTestingOnly(self, "Error reading directory: " + e.getMessage());
        }

        return fileNames.toArray(new String[0]);
    }

    public void refreshMenu(obj_id self, String[] options, String myHandler, boolean draw) throws InterruptedException
    {
        closeOldWindow(self);
        int pid;
        if (!draw)
        {
            pid = sui.listbox(self, self, OBJECT_SPAWNER_PROMPT, sui.OK_CANCEL_REFRESH, OBJECT_SPAWNER_TITLE, options, myHandler, false, false);
            sui.listboxUseOtherButton(pid, "Back");
        }
        else
        {
            pid = sui.listbox(self, self, OBJECT_SPAWNER_PROMPT, sui.OK_CANCEL, OBJECT_SPAWNER_TITLE, options, myHandler, true, false);
        }

        sui.showSUIPage(pid);
        setWindowPid(self, pid);
    }

    private void cleanScriptVars(obj_id self) throws InterruptedException
    {
        utils.removeScriptVarTree(self, "object_spawner");
    }

    private void closeOldWindow(obj_id self) throws InterruptedException
    {
        if (utils.hasScriptVar(self, "object_spawner.pid"))
        {
            final int oldpid = utils.getIntScriptVar(self, "object_spawner.pid");
            forceCloseSUIPage(oldpid);
            utils.removeScriptVar(self, "object_spawner.pid");
        }
    }

    private void setWindowPid(obj_id self, int pid) throws InterruptedException
    {
        if (pid > -1)
        {
            utils.setScriptVar(self, "object_spawner.pid", pid);
        }
    }
}
