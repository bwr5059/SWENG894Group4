<template>
  <div>
    <b-table striped hover :items="users" selectable select-mode="single"  ref="selectableTable" :fields="fields" @row-selected="enableAdd" :busy="isBusy">
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
      <template v-slot:table-busy>
        <div class="text-center text-dark my-2">
          <b-spinner class="align-middle"></b-spinner>
          <strong>Loading...</strong>
        </div>
      </template>
    </b-table>
    <b-button v-if="editable&&this.isSelected=='Voter'" v-on:click='addAdminUser'>Add</b-button>
    <b-button v-if="editable&&this.isSelected=='Admin'" v-on:click='removeAdminUser'>Remove</b-button>
  </div>
</template>

<script>

import api from '@/apis/userApi'
  export default {
      name: 'addElectionAdmin',
    //data holds variables used in the current instance of this object
    data() {
      return {
        item: null,
        selecteditem: [],
        users: null,
        editable: false,
        isSelected: false,
        isBusy: true,
        fields: ['email', 'type', 'selected'],
      }
    },

    //triggers api to get users once this object is mounted
    mounted: function(){
    api.getUsers()  
    .then(response => {  
      this.$log.debug("Users loaded: ", response.data)
      this.users = response.data._embedded.users
      this.isBusy = false
      
  })
      
    
    },
    //watching the selected item var and triggers the disable method when it changes
    watch: {
      'selecteditem': 'disable'
    },

  
    methods: {
      //disable() sets the editable flag
      disable: function(){
        if(!this.editable){
        this.editable = true
        }else if(!this.selecteditem[0]){
          this.editable = false
          this.isSelected = null
        }
      },
    //enableadd() takes the current selected row from the table and adds it to the selected item variable
    enableAdd(items){
      this.selecteditem = items
       if(this.selecteditem[0]){
      this.isSelected = this.selecteditem[0].type
      }
    },
    //addAdminUser() calls the user api to update the user profile type
    addAdminUser: function(){
      api.addAdmin(this.selecteditem[0].id, 'Admin')
      .then(response => {
        this.$log.debug("Admin added", response.data)
      }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to add admin"  
    })
    },

    removeAdminUser: function(){
      alert("removing admin")
    }
    

    //api.modifyUser(ID, email, type, fName, lName, age, race, ethnicity, gender, address, city, state, zip)
}
  }
</script>