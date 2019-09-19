<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="/">VisionElection</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/about">About</a>
          </li>
        </ul>
        <a v-if='authenticated'>user email: {{userEmail}} </a>
        <a href="/register" class="btn btn-outline-success my-2 my-sm-0 mr-1" role="button">Register</a>
        <router-link to="/profile" class="btn btn-outline-success my-2 my-sm-0 mr-1" tag="button" id='home-button'> Login </router-link>
        <button v-if='authenticated' v-on:click='logout' id='logout-button' class="btn btn-outline-success my-2 my-sm-0" href="/"> Logout </button>
        <!-- <button v-else v-on:click='login' id='login-button' class="btn btn-outline-success my-2 my-sm-0" href="/home"> Login </button> -->
      </div>
    </nav>
     
    
    <router-view/>
    <footer class ='d-flex justify-content-center'> Vision-Election 2019 </footer>
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
    this.getEmail()
  },
  watch: {
    // Everytime the route changes, check for auth status
    '$route': 'isAuthenticated'
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
