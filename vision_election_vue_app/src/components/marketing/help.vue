<template>
    <div>
    
    <b-container>
        <b-card title="Vision Election Help - Contents" sub-title="Select a category to view">
<div>
 
  <b-nav tabs>
    <b-nav-item ><router-link to="/help/account">Account</router-link></b-nav-item>
    <b-nav-item ><router-link to="/help/election">Election</router-link></b-nav-item>
    <b-nav-item ><router-link to="/help/election_settings">Election Settings</router-link></b-nav-item>
    <b-nav-item ><router-link to="/help/registration">Registration</router-link></b-nav-item>
    <b-nav-item ><router-link to="/help/voters" >Voters</router-link></b-nav-item>
    <b-nav-item ><router-link to="/help/candidates">Candidates</router-link></b-nav-item>
    <b-nav-item ><router-link to="/help/ballot">Ballot</router-link></b-nav-item>
  </b-nav> 
    
</div>
        </b-card>
    </b-container>
      <router-view></router-view>
    </div>
    
</template>


<script>
export default {
  name: 'help',
  props: {
    msg: String
  }
}
</script>