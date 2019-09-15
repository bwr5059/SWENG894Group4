<template>
    <div class ='d-flex justify-content-center'>
    Home content goes here.  You successfully logged in!
        <div>
    
            <p>email: {{userEmail}} id: {{userToken}}</p>
            
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

         userToken: function () {
        return this.activeUser ? this.activeUser.sub : ''
    }

        
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