<template>
  <div>
    <div>
      <div class="d-flex justify-content-center mb-3">
        <b-spinner v-if="!show" label="Loading..."></b-spinner>
      </div>
    </div>
    <b-card
      v-show="show"
      title="Candidate Profile"
      sub-title="general users view"
    >
    

       <div id="main-wrapper">
    
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
               
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- Row -->
                <div class="row">
                    <!-- Column -->
                    <div class="col-lg-4 col-xlg-3 col-md-5">
                        <div class="card">
                            <div class="card-body">
                                <center class="m-t-30"> <img src="data:image/png;base64,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" class="img-circle" width="150" />
                                    <h4 class="card-title m-t-10" v-text="form.fullname">Hanna Gover</h4>
                                    <h6 class="card-subtitle">Candidate</h6>
                                    
                                </center>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->
                    <!-- Column -->
                    <div class="col-lg-8 col-xlg-9 col-md-7">
                        <div class="card">
                            <div class="card-body">
                                <form class="form-horizontal form-material">
                                    <div class="form-group">
                                        <label class="col-md-12">First Name</label>
                                        <div class="col-md-12">
                                             <b-form-input
                                                  id="input-4"
                                                  class="form-control form-control-line"
                                                  v-model="form.fname"
                                                  required
                                                  placeholder="First name"
                                                  :disabled="!editable"
                                                  ></b-form-input>
                                        </div>
                                    </div>
                                    <div class="form-horizontal form-material">
                                        <label class="col-md-12">Last Name</label>
                                        <div class="col-md-12">
                                            <b-form-input
                                                  id="input-4"
                                                  class="form-control form-control-line"
                                                  v-model="form.lname"
                                                  required
                                                  placeholder="Last name"
                                                  :disabled="!editable"
                                                   ></b-form-input>
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">Phone No</label>
                                        <div class="col-md-12">
                                              <b-form-input
                                                  id="input-4"
                                                  class="form-control form-control-line"
                                                  v-model="form.phone"
                                                  required
                                                  placeholder="Contact number"
                                                  :disabled="!editable"
                                                   ></b-form-input>
                                        </div>
                                    </div>                                    
                                    <div class="form-group">
                                        <label class="col-md-12">About</label>
                                        <div class="col-md-12">
                                            
                                            <b-form-textarea
                                                  id="input-4"
                                                  class="form-control form-control-line"
                                                  v-model="form.about"
                                                  required
                                                  :disabled="!editable"
                                                   rows="5"
                                                    max-rows="6"
                                                   ></b-form-textarea>
                                             
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">Education</label>
                                        <div class="col-md-12">
                                                      
                                            <b-form-textarea
                                                  id="input-4"
                                                  class="form-control form-control-line"
                                                  v-model="form.education"
                                                  required
                                                  :disabled="!editable"
                                                   rows="5"
                                                    max-rows="6"
                                                   ></b-form-textarea>
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">Employment</label>
                                        <div class="col-md-12">
                                                      
                                            <b-form-textarea
                                                  id="input-4"
                                                  class="form-control form-control-line"
                                                  v-model="form.employment"
                                                  required
                                                  :disabled="!editable"
                                                   rows="5"
                                                    max-rows="6"
                                                   ></b-form-textarea>
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">Experience</label>
                                        <div class="col-md-12">
                                                      
                                            <b-form-textarea
                                                  id="input-4"
                                                  class="form-control form-control-line"
                                                  v-model="form.experience"
                                                  required
                                                  :disabled="!editable"
                                                   rows="5"
                                                    max-rows="6"
                                                   ></b-form-textarea>
                                        </div>
                                    </div>
                                   
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->
                </div>
                <!-- Row -->
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
           
        </div>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>
    </b-card>
  </div>
</template>

<script>
import api from '@/apis/candidateApi'
export default {
  name: "candidateProfile",
  props: {
    msg: String
  },
  data: () => {
    return {
      //activeUser: null,
       form: {
         candidateID:'',
          fullname:'',
          fname: '',
          lname: '',
          about: '',
          education: '',
          employment: '',
          experience: '',
          phone: ''         
        },
        show: false,
        editable: false,
        userObj: '',
        currentCandidateID:'',
        userProfileComplete: 0
    };
  },

  computed: {
  
   
  },

  created: function() {
    this.$log.debug("Setting candidate Data:");
   this.$log.debug("Getting candidate:");
   //gets the parameter which is the lastname of the candidate
    this.currentCandidateID = this.$route.params.cID
    //calls the getCandidate() function
    this.$log.debug("user object: "+this.userObj);
    //  alert(this.$route.params.cID+" is route");
    this.getCandidate(this.$route.params.cID);
    this.$log.debug("Created:");

  },

  mounted: function() {
    // this.currentElectionData = this.$route.params.eID
    //   this.getCandidate(this.$route.params.eID);
    this.$log.debug("Mounted:");
    //sets the userObj object from the parent userObj
    this.userObj = this.$parent.$parent.userObj;
    
    this.activeUser = this.$parent.activeUser
   
  },

  watch: {
    //checks when the routing change and refreshes the current election
    $route: "refreshData"
  },

  methods: {
    //refreshData() function gets the current election data and sets it to the election ID from the routing
    //and then calls the getCandidate() function
    async refreshData() {
      this.$log.debug("Refreshing data:");
      this.currentCandidateID = this.$route.params.cID;
          this.getCandidate(this.currentCandidateID);
    },
    /**getCandidate() function calls the getCandidate API and returns the json data.  If the response
     * is successful, it sets the current form data to the candidate data received and sets the show variable
     * to show the data card.
     * @{id} inbound id of the election being retrieved by the api
     * update response data
     */
    getCandidate: function(id) {
      this.$log.debug("Calling API for iD"+id );
      this.show = false;
      //makes a request to the api to get the candidate by last name
       api.getCandidateByName(id)  
    .then(response => {  
      this.$log.debug("Candidate Data loaded: ", response.data)
      this.userObj = response
      this.form.fullname = this.userObj.data.first_name + ' '+ this.userObj.data.last_name
      this.form.fname = this.userObj.data.first_name
      this.form.lname = this.userObj.data.last_name
      this.form.about = this.userObj.data.about
      this.form.education = this.userObj.data.education
      this.form.employment = this.userObj.data.employment
      this.form.experience = this.userObj.data.experience
      this.form.phone = this.userObj.data.contact
      if(this.userObj!=""){
        this.userProfileComplete = 1
      }else{
        this.userProfileComplete = 0
      } 
      this.show = true;
      })
        .catch(error => {
          this.$log.debug(error);
          this.error = "Failed to get election";
        });
    },
   
  }
};
</script>
