<template>
  <b-container>
      <b-card title="Welcome to Vision Election...">
        <b-card-text>
          <b>Create and Customize Elections</b> <br>

          Fast and easy creation of elections without the hassle. Vision Election System offers many policy customization options including determining how many candidates a voter can vote for and options for writing in a candidate or abstaining from voting.  
          <br>
          <br>
          <b>Manage your Elections</b> <br>

          Worry free management of your elections. Control who can vote in elections by issuing a generated key and remove voters who can no longer vote. Add and remove candidates before the start of an election. 
          <br>
          <br>
          <b>Participate in an Election</b> <br>

          Participate as a voter in an election with a few simple clicks. Our easy to use interface makes your online voting experience worry free. 
        </b-card-text>
      </b-card>
  </b-container>
</template>
<script>
import api from '@/apis/userApi'

export default {
  name: 'home',
  props: {
    msg: String,   
  },data: () => {  
      return {  
        todos: [], 
        error: null,
        userProfileComplete: null,
        authorized: true,
        userObj: null,
        activeUser: null
      }  
    },    
 created: function () {  
   this.$log.debug("home created")
  },  

  mounted: function() {
    this.$log.debug("home mounted")
  },
  watch: {  
    '$parent.profileComplete': 'checkUser'
  },  
  methods: {  
    /**
     * refreshActiveUser refreshes user data from the okta user id and calls the get user API call.
     */
    refreshActiveUser: function(){
      this.activeUser =  this.$parent.activeUser
      this.$log.debug(this.activeUser)
      api.getUser(this.activeUser.sub)  
      .then((response => {  
        this.$log.debug("Data loaded home: ", response.data)  
        this.todos = response.data  
        this.userProfileComplete = 1
      }))  
      .catch(error => {  
        this.$log.debug(error)  
        this.error = "User Profile not complete"  
        this.userProfileComplete = 0
      })
    },
    /**
     * checkUser() checks if the user profile is complete.  If it is not, it redirects the user
     * to the user Profile to complete user profile registration.
     */
    checkUser() {
      if(this.$parent.profileComplete==0||this.$parent.profileComplete==null){
        this.$log.debug("redirecting to profile") 
        this.$router.push({path:'/profile'})
      }
    },
  },
}
</script>