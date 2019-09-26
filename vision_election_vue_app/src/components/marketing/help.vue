<template>
    <div>
    <b-container>
        <b-card title="Vision Election Help - Contents" sub-title="Select a category to view">
<b-list-group>
  <b-list-group-item>
    <router-link to="/help/applicationHelp" class="navbar-text" id='appHelp'> Application Help </router-link>
  </b-list-group-item>
  <b-list-group-item href="/help/registration">Registration</b-list-group-item>
  <b-list-group-item href="/help/Elections">Elections</b-list-group-item>
  <b-list-group-item href="/help/candidates">Candidates</b-list-group-item>
  <b-list-group-item href="/help/voters">Voters</b-list-group-item>
</b-list-group>
        </b-card>
    </b-container>
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