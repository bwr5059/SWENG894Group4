<template>
  <div>
    <b-table striped hover :items="items" selectable select-mode="single" @row-selected="selected" ref="selectableTable" :fields='fields' :busy="isBusy">
      <template v-slot:table-busy>
        <div class="text-center text-dark my-2">
          <b-spinner class="align-middle"></b-spinner>
          <strong>Loading...</strong>
        </div>
      </template>
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
        isBusy: true,
        fields: ['electionID', 'title', 'start_date', 'close_date'],
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
      this.isBusy=false
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to get elections"  
	});  
    },

    selected: function(items){
      this.selecteditem = items
      //selectedElectionID = this.selecteditem[0].electionId
   
      this.$router.push({path: `/app/home/election/${this.selecteditem[0].electionID}/details`})
  
    }
}
  }
</script>