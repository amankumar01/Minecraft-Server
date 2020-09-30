#Information
This is another part of essentials chat plugin that I decided to implement myself. 
#NOTE
This plugin will not work as of right now without my ranksmanager plugin as the plugin is currently fully depending on that plugin.
Basically for future implementations, it could be possible to accept other plugin ranks managers however as of right now this plugin was only created for use with my plugins.
If in the future I want to publish some of these plugins I have tinkered up, the structure of the plugin source code allows for adaptability to other plugins.

#What is it?
Asynchronous chat managing. This plugin changes the originally minecraft chat format.
EX. <NAME> message
to a custom format of 
EX. [RANK] NAME [TAGS]: message
This was created to allow the use of rankmanager to truly work in game for the purpose of showing all other players the staff rank.
The format can easily be customizable if plugin is to ever go public by using configuration files to pull the requested format.

#future
This plugin will manage chat for the purpose of language monitoring to ensure proper and healthy communication between players.
Language bounds can be set with a configuration file if plugin is to go public.
