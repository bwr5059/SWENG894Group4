<template>
  <div>
    <b-table striped hover :items="items" selectable select-mode="single" @row-selected="selected" ref="selectableTable" :fields='fields'>
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

import api from '@/apis/electionApi'
  export default {
      name: 'elections',
    data() {
      return {
        items: null,
        selecteditem: null,
        data: null,
        fields: ['electionId', 'title', 'closeDate', 'closeTime', 'numCandidates', 'numVotes'],
      }
    },


    mounted: function(){

        this.getElections()
    },
    methods: {

    async refreshData () {  
      this.currentElectionData = this.$route.params.eID
      this.getElection(this.currentElectionData)
      
    },  

    getElections: function(){
        api.getElections().then( (response) => {  
      this.$log.debug("Success getting election:", response);  
      this.items = response.data
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to get elections"  
	});  
    },

    selected: function(items){
      this.selecteditem = items
      //selectedElectionID = this.selecteditem[0].electionId
   
      this.$router.push({path: `/app/home/election/${this.selecteditem[0].electionId}/details`})
  
    }
}
  }
</script>