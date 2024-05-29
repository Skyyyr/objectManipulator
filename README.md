# Object Mover Readme

The object mover is meant to making moving objects in-game easier. Use the sliders and press the slider's button to move it in that direction.
The object mover script when attached will automatically attach the object spawner script.
Be sure to review and follow the instructions below, especially if you intend to change the location where the scripts will be stored within your dsrc.
You are able to spawn objects with the object spawner tool that comes with this.
Take note that with the object spawner you'll have access to spawning objects that shouldn't be spawned, so be aware of what you're selecting.


# Installation

1. Inside client folder put the ui folder inside your client directory
	1. If you already have a ui folder in your client directory then put the object_mover.inc inside it

2. Inside your ui folder if you have a ui_root.ui open it and add: `<include>object_mover.inc</include>`
	1. You should add that at line 18, which is where the root starts to include other inc files
	2. If you do not have a ui_root.ui inside your ui folder then extract your latest ui_root.ui and put it in the ui directory and make the edit

3. Add the scripts (`object_spawner.java` & `object_mover.java`) to `scripts/developer`
	1. If you decide to put the scripts somewhere else just be sure to update the package path
	2. If you changed the location of these scripts be sure to update the `object_spawner.java` `DEFAULT_PATH` to the new path.

4. If your dsrc structure doesn't follow swg-source pathing then be sure to update the `object_spawner.java` `DEFAULT_PATH` accordingly otherwise ignore this step

5. Compile java and run the server

# Uninstall

1. Delete or remove the ui/object_mover.inc from your client directory
2. Delete or remove the object_mover.java from your dsrc
3. Compile java, restart your client

# Usage

1. Log into your godmode character and attach the `object_mover.java` to your character
	1. `script attach developer.object_mover oid` where oid is your character's object id
	2. If you didn't put the scripts inside the developer folder then be sure to adjust accordingly
2. After logging in simple say `objectMover` it's not case sensitive
3. Use the sliders and buttons to move the object around
4. Use the object spawner button to pull the list view, for folders with lots of contents it may have a delay when populating the list
