<template>
  <div id="app">
    <b-navbar class="navbar navbar-expand-lg navbar-dark bg-dark">
      <b-navbar-brand href="/">VisionElection</b-navbar-brand>
      <b-navbar-toggle class="navbar-toggler" target="" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </b-navbar-toggle>

      <b-collapse class="collapse navbar-collapse" id="navbarSupportedContent">
        <b-navbar-nav>
          <li class="nav-item active">
            <a class="nav-link" v-if='authenticated' href="/app/user/home">Home</a>
            <a class="nav-link" v-else href="/">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/about">About</a>
          </li>
        </b-navbar-nav>
        <b-navbar-nav class="ml-auto">
        <b-nav-item v-if='authenticated' href="/profile">{{userEmail}} </b-nav-item>
        <b-nav-item href="/help">Help</b-nav-item>
        
        <!-- <router-link v-if='authenticated' to="/" v-on:click='logout' class="btn btn-outline-success my-2 my-sm-0 mr-1" tag="button" id='home-button'> Logout </router-link> -->
        <router-link v-show="!authenticated" to="/app/user/home" class="btn btn-info my-2 my-sm-0 mr-1" tag="button" id='home-button'> Login </router-link>
        <button v-if='authenticated' v-on:click='logout' id='logout-button' class="btn btn-success my-2 my-sm-0"> Logout </button>
        <!--<button v-else v-on:click='login' id='login-button' class="btn btn-outline-success my-2 my-sm-0" href="/home"> Login </button> -->
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
     <b-container>
    
    <router-view/>
    <footer class ='d-flex justify-content-center'> Vision-Election 2019 </footer>
     </b-container>
  </div>
</template>

<script>
  
  
export default {
  name: 'master',
  components: {
  
  },
  props: {
    msg: String,
    activeUser: Object
  },
  data: function () {
    return {
      authenticated: false
    }
  },
  computed: {
        userEmail: function () {
        return this.activeUser ? this.activeUser.email : ''
      },
    },
  created () {
    this.isAuthenticated()
    
  },

  mounted () {
    this.getEmail()
    
  },
  watch: {
    // Everytime the route changes, check for auth status
    '$route': 'isAuthenticated',
    'authenticated': 'getEmail'
  },
  
  methods: {
    async isAuthenticated () {
      this.authenticated = await this.$auth.isAuthenticated()
      
    },
    login () {
      this.$auth.loginRedirect('/')
    },
    async logout () {
      await this.$auth.logout()
      await this.isAuthenticated()
      // Navigate back to home
      this.$router.push({ path: '/' })
    },
    async getEmail (){
      this.activeUser = await this.$auth.getUser()  
    }
  }
  
}
</script>