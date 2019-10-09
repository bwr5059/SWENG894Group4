<template>
  <div>
    <b-table striped hover :items="users" selectable select-mode="single"  ref="selectableTable" >
      <!-- <template v-slot:cell(closeTime)="{ rowSelected }">
        <template v-if="rowSelected">
          <span aria-hidden="true">&check;</span>
          <span class="sr-only">Selected</span>
        </template>
        <template v-else>
          <span aria-hidden="true">&nbsp;</span>
          <span class="sr-only">Not selected</span>
        </template>
      </template> -->
    </b-table>
  </div>
</template>

<script>

import api from '@/apis/userApi'
  export default {
      name: 'addElectionAdmin',
    data() {
      return {
        items: null,
        selecteditem: null,
        users: null,
        fields: ['User', 'Role'],
      }
    },


    mounted: function(){
    api.getUsers()  
    .then(response => {  
      this.$log.debug("Users loaded: ", response.data)
      this.users = response.data
      
  })
      
    
    },
    methods: {

    
}
  }
</script>