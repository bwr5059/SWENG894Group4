<template>
    <div class ='d-flex justify-content-center'>
    Home content goes here.  You successfully logged in!


    </div>
</template>


<script>
export default {
  name: 'home',
  props: {
    msg: String
  },data: () => {  
      return {  
        activeUser: null  
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
    }  
  },
}
</script>