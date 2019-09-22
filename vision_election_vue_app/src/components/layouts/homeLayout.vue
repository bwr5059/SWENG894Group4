<template>
    <div class=container>
        <b-navbar type="light">
            <b-navbar-nav>
                <router-link to="/app/user/home" class="navbar-brand">Election</router-link>
                <router-link v-show="!$route.authorized" to="/app/user/createElection" class="btn btn-secondary my-2 my-sm-0 mr-1" tag="button" id='home-button'> New </router-link>
                <router-link to="/app/home/elections" class="btn btn-secondary my-2 my-sm-0 mr-1">Search all</router-link>
            </b-navbar-nav>
            <b-navbar-nav class="ml-auto">
                <b-nav-form>
                <b-form-input size="sm" class="mr-sm-2" placeholder="Search" v-model="form.id" @keydown.enter.prevent></b-form-input>
                <b-button size="sm"  v-on:click='searchElection'>Search</b-button>
                </b-nav-form>
            </b-navbar-nav>
        </b-navbar>
        <router-view></router-view>
    </div>
</template>

<script>
export default {
  name: 'homeLayout',
  props: {
    msg: String,
    
   
  },

   data: () => {  
      return {
    authorized: true,
    form: {
          id: '',
        },
      }
},
    methods: {
    searchElection: function(){
        alert("test")
        this.$router.push({path: `/app/home/election/${this.form.id}/details`})
    }
    }
}
</script>