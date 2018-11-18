# GrantDangerousAndroidPermissions
This is an example of an android application that lets users grant permissions that are labeled "Dangerous"


Most permissions are pretty straightforward to handle in the Android ecosystem, like camera permission and internet permission.
Android has provided tools so it can easily be granted by the users. Some of Android permission are labeled "Dangerous" 
which means that the Users have to go the settings themselves and grant access manually. This could be a burden- like 
what if the user forgets that they had your application open when they go to the settings- or what if they can't find
the settings to grant the access. 
So I created a simple solution and here's the example. Basically, what this application does is that it opens up 
the settings programmitically and immediately goes to the part of the settings where access is granted. Also, it creates 
a service so that it checks if the permission is granted every 1 second. Once the permission is granted, the user 
is taken immediately back to the app so they don't forget about anything. Less frustrating for both sides. 
