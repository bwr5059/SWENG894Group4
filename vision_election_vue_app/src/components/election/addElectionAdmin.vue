<template>
  <div>
    <b-table striped hover :items="users" selectable select-mode="single"  ref="selectableTable" :fields="fields" @row-selected="enableAdd">
      <template v-slot:cell(selected)="{ rowSelected }">
        <template v-if="rowSelected">
          <span aria-hidden="true">&check;</span>
          <span class="sr-only">Selected</span>
        </template>
        <template v-else>
          <span aria-hidden="true">&nbsp;</span>
          <span class="sr-only">Not selected</span>
        </template>
      </template>
    </b-table>
    <b-button v-if="editable" v-on:click='addAdminUser'>Add</b-button>
  </div>
</template>

<script>

import api from '@/apis/userApi'
  export default {
      name: 'addElectionAdmin',
    data() {
      return {
        items: null,
        selecteditem: [],
        users: null,
        editable: false,
        fields: ['email', 'type', 'selected'],
      }
    },


    mounted: function(){
    api.getUsers()  
    .then(response => {  
      this.$log.debug("Users loaded: ", response.data)
      this.users = response.data._embedded.users
      this.editable = false
      
  })
      
    
    },
    methods: {

    enableAdd(items){
      this.selecteditem = items
      if(!this.editable){
        this.editable = true
      }else if(this.editable){
        this.editable = false
      }
      
    },

    addAdminUser: function(){
      api.addAdmin(this.selecteditem[0].id, 'Admin')
      .then(response => {
        this.$log.debug("Admin added", response.data)
      }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to add admin"  
    })
    },
    

    //api.modifyUser(ID, email, type, fName, lName, age, race, ethnicity, gender, address, city, state, zip)
}
  }
</script>