<template>
    <div class=container>
        <b-navbar type="dark" variant="dark">
            <b-navbar-nav>
                <router-link to="/app/user/home" class="nav-link">Election</router-link>
                <router-link v-show="!authorized" to="/app/user/createElection" class="btn btn-primary my-2 my-sm-0 mr-1" tag="button" id='home-button'> New </router-link>
            </b-navbar-nav>
            <b-navbar-nav class="ml-auto">
                <b-nav-form>
                <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
                <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
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
    authorized: false,
   
  }
}
</script>