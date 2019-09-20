<template>
    <div class ='d-flex justify-content-center'>
    Home content goes here.  You successfully logged in!
        <div class='d-flex justify-content-center'>
    
            email: {{userEmail}} id: {{userID}} firstname: {{userFName}} lastname: {{userLName}}
            
        </div>
    </div>
    
</template>


<script>


export default {
  name: 'home',
  props: {
    msg: String,
    activeUser: Object
    
  },data: () => {  
      return {  
        activeUser: null  
      }  
    },  

    computed: {
        userEmail: function () {
        return this.activeUser ? this.activeUser.email : ''
      },

         userID: function () {
        return this.activeUser ? this.activeUser.sub : ''
    },
        userFName: function () {
        return this.activeUser ? this.activeUser.given_name : ''
    },
        userLName: function () {
        return this.activeUser ? this.activeUser.family_name : ''
    },


//you can retrieve first name as given_name and last name as family_name
        
    },
  
  async created () {  
    await this.refreshActiveUser()  
  },  
  
  watch: {  
    '$route': 'refreshActiveUser'  
  },  
  
  methods: {  
    async refreshActiveUser () {  
      this.activeUser = await this.$auth.getUser()  
      this.$log.debug('activeUser',this.activeUser)  
    },  
  
    async handleLogout () {  
      await this.$auth.logout()  
      await this.refreshActiveUser()  
      this.$router.go('/')  
    },



  
  },

  
}
</script>