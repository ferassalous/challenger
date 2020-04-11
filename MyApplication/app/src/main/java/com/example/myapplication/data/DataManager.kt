package com.example.myapplication.data
/*
    DataManager will be where we manage all the data of the app locally.
    The class can be looked at as a Singleton class because we will only need one instanse of the
    data to be passed around the app.
 */
object DataManager{
    /*
        A list to hold the users
     */
     val users = HashMap<String, String>()

    /*
        Since an object class can not have a constructor, this is how we will initilize
        all the data we need.
     */
    init{
        initUsers()
    }

    private fun initUsers(){
        val demoUser = User("demo", "demopass")
        users.put(demoUser.name, demoUser.password)
    }

    fun verifyUser(username : String, password: String) : Boolean{

        val containsUser = users.containsKey(username)
        // if the hashmap does not contain the user, quit.
        if(!containsUser){
            return false;
        }
        // expected password of the user if they are in the map
        val expectedPassword = users[username]
        // if the password given by the user is not correct, quit.
        if(!expectedPassword.equals(password)){
           return false
        }
        // user is in the system and password matches, continue.
        return true
    }
}