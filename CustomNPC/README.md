Custom npc placement and creation

command:
./npccreate (npcname) (skin of player name)
./npc create (npcname)    <-  this uses the player calling the command's skin

Using hash maps to store the locations and other key variables to recreate the npc upon server restart and/or server close.
Uses player head posisiton as a basis for setting the pitch and yaw, That being said whatever position your in game character is looking at, that position will be used 
to create the npc.
