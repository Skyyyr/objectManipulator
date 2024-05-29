package script.developer;

import script.dictionary;
import script.library.sui;
import script.library.utils;
import script.location;
import script.obj_id;

public class object_mover extends script.base_script
{
    public object_mover() {}

    public static final String DEFAULT_PATH = "developer.object_spawner";
    public static final String CURRENT_TARGET = "object_mover.current_target";
    public static final String PID_NAME = "object_mover.pid";
    public static final String OBJ_YAW = "object_mover.yaw";
    public static final String OBJ_PITCH = "object_mover.pitch";
    public static final String OBJ_ROLL = "object_mover.roll";
    public static final String OBJ_X = "object_mover.x";
    public static final String OBJ_Y = "object_mover.y";
    public static final String OBJ_Z = "object_mover.z";
    public static final String SLIDER_PITCH = "pitch.slider.value";
    public static final String SLIDER_ROLL = "roll.slider.value";
    public static final String SLIDER_YAW = "yaw.slider.value";
    public static final String SLIDER_X = "x.slider.value";
    public static final String SLIDER_Y = "y.slider.value";
    public static final String SLIDER_Z = "z.slider.value";
    public static final String NOT_VALID_OBJ = "You must select a valid object to move.";
    public static final String NOT_VALID_MOVE_AMT = "You must select a value above or below 0 to move an object.";

    public int OnAttach(obj_id self) throws InterruptedException
    {
        sendSystemMessageTestingOnly(self, "Say 'objectMover' to activate the Object Mover.");
        attachScript(self, DEFAULT_PATH);
        return SCRIPT_CONTINUE;
    }

    public int OnDetach(obj_id self) throws InterruptedException
    {
        messageTo(self, "handleRemoveTarget", null , 0.0f, false);
        detachScript(self, DEFAULT_PATH);
        return SCRIPT_CONTINUE;
    }

    public int OnSpeaking(obj_id self, String text) throws InterruptedException
    {
        if (text.equalsIgnoreCase("objectMover"))
        {
            //Clear previous objvars if they exist
            messageTo(self, "handleRemoveTarget", null, 0.0f, false);
            handleObjectMover(self);
        }

        return SCRIPT_CONTINUE;
    }

    private void handleObjectMover(obj_id self) throws InterruptedException
    {
        int pid = createSUIPage("/ObjectMover.mover", self, self);

        utils.setScriptVar(self, PID_NAME, pid);

        final String currentTargetString = utils.hasScriptVar(self, CURRENT_TARGET) ? utils.getObjIdScriptVar(self, CURRENT_TARGET) + "" : "0";

        utils.setScriptVar(self, PID_NAME, pid);

        setSUIAssociatedLocation(pid, self);
        sui.setPid(self, pid, PID_NAME);

//        Label for current obj
        setSUIProperty(pid, "currentTarget", "Text", currentTargetString);

//        Buttons
        subscribeToSUIEvent(pid, sui_event_type.SET_onButton, "buttonSend", "handleSetTarget");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onButton, "buttonSend", "buttonSend", "LocalText");

        subscribeToSUIEvent(pid, sui_event_type.SET_onButton, "buttonMoveToMe", "handleMoveToMe");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onButton, "buttonMoveToMe", "buttonMoveToMe", "LocalText");

        subscribeToSUIEvent(pid, sui_event_type.SET_onButton, "buttonObjectViewer", "handleOpenObjectViewer");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onButton, "buttonObjectViewer", "buttonObjectViewer", "LocalText");

        subscribeToSUIEvent(pid, sui_event_type.SET_onClosedCancel, "buttonCancel", "handleRemoveTarget");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onClosedCancel, "buttonCancel", "buttonCancel", "LocalText");

        // Movement buttons
        subscribeToSUIEvent(pid, sui_event_type.SET_onButton, "yaw.buttonMove", "handleMoveTargetYaw");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onButton, "yaw.buttonMove", "yaw.buttonMove", "LocalText");

        subscribeToSUIEvent(pid, sui_event_type.SET_onButton, "roll.buttonMove", "handleMoveTargetRoll");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onButton, "roll.buttonMove", "roll.buttonMove", "LocalText");

        subscribeToSUIEvent(pid, sui_event_type.SET_onButton, "pitch.buttonMove", "handleMoveTargetPitch");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onButton, "pitch.buttonMove", "pitch.buttonMove", "LocalText");

        subscribeToSUIEvent(pid, sui_event_type.SET_onButton, "x.buttonMove", "handleMoveTargetX");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onButton, "x.buttonMove", "x.buttonMove", "LocalText");

        subscribeToSUIEvent(pid, sui_event_type.SET_onButton, "y.buttonMove", "handleMoveTargetY");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onButton, "y.buttonMove", "y.buttonMove", "LocalText");

        subscribeToSUIEvent(pid, sui_event_type.SET_onButton, "z.buttonMove", "handleMoveTargetZ");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onButton, "z.buttonMove", "z.buttonMove", "LocalText");

//        Sliders
        subscribeToSUIEvent(pid, sui_event_type.SET_onSliderbar, "pitch.slider", "handleSliderPitch");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onSliderbar, "pitch.slider", "pitch.slider", "value");

        subscribeToSUIEvent(pid, sui_event_type.SET_onSliderbar, "roll.slider", "handleSliderRoll");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onSliderbar, "roll.slider", "roll.slider", "value");

        subscribeToSUIEvent(pid, sui_event_type.SET_onSliderbar, "yaw.slider", "handleSliderYaw");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onSliderbar, "yaw.slider", "yaw.slider", "value");

        subscribeToSUIEvent(pid, sui_event_type.SET_onSliderbar, "x.slider", "handleSliderX");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onSliderbar, "x.slider", "x.slider", "value");

        subscribeToSUIEvent(pid, sui_event_type.SET_onSliderbar, "y.slider", "handleSliderY");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onSliderbar, "y.slider", "y.slider", "value");

        subscribeToSUIEvent(pid, sui_event_type.SET_onSliderbar, "z.slider", "handleSliderZ");
        subscribeToSUIPropertyForEvent(pid, sui_event_type.SET_onSliderbar, "z.slider", "z.slider", "value");

        showSUIPage(pid);
        flushSUIPage(pid);
    }

    public int handleSetTarget(obj_id self, dictionary params) throws InterruptedException
    {
        final obj_id setTarget = getIntendedTarget(self);
        if (!isValidId(setTarget))
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_OBJ);
            return SCRIPT_CONTINUE;
        }

        utils.setScriptVar(self, CURRENT_TARGET, setTarget);

        final int currentPid = utils.getIntScriptVar(self, PID_NAME);
        setSUIProperty(currentPid, "currentTarget", "Text", setTarget + "");
        flushSUIPage(currentPid);

        setDefaultValues(self);

        return SCRIPT_CONTINUE;
    }

    public void setDefaultValues(obj_id self) throws InterruptedException
    {
        utils.setScriptVar(self, OBJ_X, "0");
        utils.setScriptVar(self, OBJ_Y, "0");
        utils.setScriptVar(self, OBJ_Z, "0");
        utils.setScriptVar(self, OBJ_YAW, "0");
        utils.setScriptVar(self, OBJ_ROLL, "0");
        utils.setScriptVar(self, OBJ_PITCH, "0");
    }

    public int handleRemoveTarget(obj_id self, dictionary params) throws InterruptedException
    {
        utils.removeScriptVarTree(self, "object_mover");
//        if (utils.hasScriptVar(self, CURRENT_TARGET))
//        {
//            utils.removeScriptVar(self, CURRENT_TARGET);
//        }
//        if (utils.hasScriptVar(self, OBJ_X))
//        {
//            utils.removeScriptVar(self, OBJ_X);
//        }
//        if (utils.hasScriptVar(self, OBJ_Y))
//        {
//            utils.removeScriptVar(self, OBJ_Y);
//        }
//        if (utils.hasScriptVar(self, OBJ_Z))
//        {
//            utils.removeScriptVar(self, OBJ_Z);
//        }
//        if (utils.hasScriptVar(self, OBJ_YAW))
//        {
//            utils.removeScriptVar(self, OBJ_YAW);
//        }
//        if (utils.hasScriptVar(self, OBJ_ROLL))
//        {
//            utils.removeScriptVar(self, OBJ_ROLL);
//        }
//        if (utils.hasScriptVar(self, OBJ_PITCH))
//        {
//            utils.removeScriptVar(self, OBJ_PITCH);
//        }

        return SCRIPT_CONTINUE;
    }

    public int handleMoveToMe(obj_id self, dictionary params) throws InterruptedException
    {
        final obj_id target = utils.getObjIdScriptVar(self, CURRENT_TARGET);
        if (!isValidId(target))
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_OBJ);
            return SCRIPT_CONTINUE;
        }

        final location loc = getLocation(self);
        setLocation(target, loc);

        return SCRIPT_CONTINUE;
    }

    public int handleOpenObjectViewer(obj_id self, dictionary params) throws InterruptedException
    {
        object_spawner spawner = new object_spawner();
        spawner.openObjectViewer(self);
        return SCRIPT_CONTINUE;
    }

    public int handleMoveTargetYaw(obj_id self, dictionary params) throws InterruptedException
    {
        final obj_id target = utils.getObjIdScriptVar(self, CURRENT_TARGET);
        if (!isValidId(target))
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_OBJ);
            return SCRIPT_CONTINUE;
        }

        final int amount = utils.stringToInt(utils.getStringScriptVar(self, OBJ_YAW));
        if (amount == 0)
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_MOVE_AMT);
            return SCRIPT_CONTINUE;
        }

        modifyYaw(target, amount);

        return SCRIPT_CONTINUE;
    }

    public int handleMoveTargetRoll(obj_id self, dictionary params) throws InterruptedException
    {
        final obj_id target = utils.getObjIdScriptVar(self, CURRENT_TARGET);
        if (!isValidId(target))
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_OBJ);
            return SCRIPT_CONTINUE;
        }

        final int amount = utils.stringToInt(utils.getStringScriptVar(self, OBJ_ROLL));
        if (amount == 0)
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_MOVE_AMT);
            return SCRIPT_CONTINUE;
        }

        modifyRoll(target, amount);

        return SCRIPT_CONTINUE;
    }

    public int handleMoveTargetPitch(obj_id self, dictionary params) throws InterruptedException
    {
        final obj_id target = utils.getObjIdScriptVar(self, CURRENT_TARGET);
        if (!isValidId(target))
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_OBJ);
            return SCRIPT_CONTINUE;
        }

        final int amount = utils.stringToInt(utils.getStringScriptVar(self, OBJ_PITCH));
        if (amount == 0)
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_MOVE_AMT);
            return SCRIPT_CONTINUE;
        }

        modifyPitch(target, amount);

        return SCRIPT_CONTINUE;
    }

    public int handleMoveTargetX(obj_id self, dictionary params) throws InterruptedException
    {
        final obj_id target = utils.getObjIdScriptVar(self, CURRENT_TARGET);
        if (!isValidId(target))
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_OBJ);
            return SCRIPT_CONTINUE;
        }

        final int amount = utils.stringToInt(utils.getStringScriptVar(self, OBJ_X));
        if (amount == 0)
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_MOVE_AMT);
            return SCRIPT_CONTINUE;
        }

        final location loc = getLocation(target);
        loc.x += amount;
        setLocation(target, loc);

        return SCRIPT_CONTINUE;
    }

    public int handleMoveTargetY(obj_id self, dictionary params) throws InterruptedException
    {
        final obj_id target = utils.getObjIdScriptVar(self, CURRENT_TARGET);
        if (!isValidId(target))
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_OBJ);
            return SCRIPT_CONTINUE;
        }

        final int amount = utils.stringToInt(utils.getStringScriptVar(self, OBJ_Y));
        if (amount == 0)
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_MOVE_AMT);
            return SCRIPT_CONTINUE;
        }

        final location loc = getLocation(target);
        loc.y += amount;
        setLocation(target, loc);

        return SCRIPT_CONTINUE;
    }

    public int handleMoveTargetZ(obj_id self, dictionary params) throws InterruptedException
    {
        final obj_id target = utils.getObjIdScriptVar(self, CURRENT_TARGET);
        if (!isValidId(target))
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_OBJ);
            return SCRIPT_CONTINUE;
        }

        final int amount = utils.stringToInt(utils.getStringScriptVar(self, OBJ_Z));
        if (amount == 0)
        {
            sendSystemMessageTestingOnly(self, NOT_VALID_MOVE_AMT);
            return SCRIPT_CONTINUE;
        }

        final location loc = getLocation(target);
        loc.z += amount;
        setLocation(target, loc);

        return SCRIPT_CONTINUE;
    }

    public int handleSliderPitch(obj_id self, dictionary params) throws InterruptedException
    {
        utils.setScriptVar(self, OBJ_PITCH, (String) params.get(SLIDER_PITCH));

        return SCRIPT_CONTINUE;
    }

    public int handleSliderRoll(obj_id self, dictionary params) throws InterruptedException
    {
        utils.setScriptVar(self, OBJ_ROLL, (String) params.get(SLIDER_ROLL));

        return SCRIPT_CONTINUE;
    }

    public int handleSliderYaw(obj_id self, dictionary params) throws InterruptedException
    {
        utils.setScriptVar(self, OBJ_YAW, (String) params.get(SLIDER_YAW));

        return SCRIPT_CONTINUE;
    }

    public int handleSliderX(obj_id self, dictionary params) throws InterruptedException
    {
        utils.setScriptVar(self, OBJ_X, (String) params.get(SLIDER_X));

        return SCRIPT_CONTINUE;
    }

    public int handleSliderY(obj_id self, dictionary params) throws InterruptedException
    {
        utils.setScriptVar(self, OBJ_Y, (String) params.get(SLIDER_Y));

        return SCRIPT_CONTINUE;
    }

    public int handleSliderZ(obj_id self, dictionary params) throws InterruptedException
    {
        utils.setScriptVar(self, OBJ_Z, (String) params.get(SLIDER_Z));

        return SCRIPT_CONTINUE;
    }
}
