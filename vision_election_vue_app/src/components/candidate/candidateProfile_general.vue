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
                                <center class="m-t-30"> <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAATlBMVEWVu9////+Rud6Ntt2LtdyPuN3H2u250emYveDq8fj6/P6zzeeKtNzz9/uiw+LQ4PDd6PTh6/WsyeXL3e/B1uvt8/mfweGvy+be6fTX5PJcXCnCAAAG9UlEQVR4nO2d2XKjMBBFTUvs+2Ji/v9HBznx2MTYBnRlNY7OVM3L1KS4EVKvag4Hh8PhcDgcDofD4XCwgsgnXwgx/k1k+2GwjNIk9U0XlEN1Gv8MZdA1PckPEUpCFEGVe/fkVVAIsXeRgsJTMqPuQlKHJGw/5HYoa05P1F04Ndk+F5KycO7dnCMPd6iRZPrs7bx7W1O5M41+H6/Qp4h73/ZDr0EGK/UpAmn7sZcj1i7gzzLuZRWpX7MDb0n6XWxGajbqUzQ7kKglcA8SqdAS6HkFe4maAj3PtoAXZEvdmMfkrP1UOWgL9LyBsV2kL4BAz/viuxX9rYZwSsLW8vslRKDnlVwlRiCBnhfZljKPqGAKK6bnKUwgU6MoULtQUXJcRAEU6HkMFVIIVRjys4myhiqMGTo2UIEMzxrwS8rwNfURPvctFTe/RuiHTVPYBVE4j+0CM8+NUrjClNdGpBausOWl0MdaQ0XN66iR6INmPGp42XxQdH8Ls0if4AI9j9c+xBsLz+tti7pFO9M9B6/sNyaNOIVVUhHudytY+d5OoVPoFNrHQGjBLbjQK23P09gWNcGIxbctaoIJr41XkP/5nrcwED3xSkXJI1zhkVkE/PFZDFiB+wqzUjd1cIUdr5NGs5ttDl4G/w/kvPHmglmqbXNb8GNiXubQwGHK7Cj9CxXSQw9WyCpbegac12d30MB7MWpeXqmCtlwieUzAbhuiE/u8UvrfZFCFmW05MwjkRqy52XsFNLxgFlj8gMzV2NYyDzCTceS4DaGvKUNbcebjO9lxERS7yOkCLL7gF1dcQJ2mbAUeBKbJdOAXV/wHEyTyCw2vQEIohoHTFUiAwS1ROiXTNxgxT3/mAmAROUaGt2jvRNa78Iyu68b5IP1GMzXMLhE8g1ZakWES8R6tQhurjsuHaPhuA9eg4hebG/eZtec/Y6NC24+9nI1bkf/klitiSywc7mQTfiPWZ6W6XQncIHFvAkeJ65pq090JVGHGcucm4R5QzEOHpXFGfdiPQJrYbLnsSA2n/4mzWsq66aQAotce3DCdRCvjju0gTOGrQvevYQh+9FzjEE2jCanSIIHP8Nwh0f8Ehr+nH4pD8MhPzYPDLymXwkDZ8xq/S8JPrymo490/yz6ofx+sSR3091vuWqCLU5+LSKKsKCfPn0R3jzb+Dvo0KE/x8XiMT2WQ9jPP/2ukZFIWmf1p0ffyzqRzYRDReZy3Gug9++Dy3kewLpLknLzzAbL+qHgQOI8irdkPEbWPQ928WKdRNE9+VhvZOFvl1wuPZTgszyr5hxd2s/5690Jm6YK2hGDhYUhiQcfYMX1ntt+PFpYn2vFUefnDxMKZGnH0tlSjXBH7DYV89ly+bFZk5ro3Zarkutl6ednM2+7RRjblurRc9RaJcn0BLanbphdSjkoVwpdS9F/tnZ/zmneMANtcXEryeijbIAjacqjzral/86Upib/gtI7SsEQjV5rXYfoCtG19nuHMOHBE6XaMlm9MXNlej8FL3oBOCwQGuzV4LKHBRQRfGtmOMaNoYqzANgx12IJvxehgqEvawNS5rZgphxuZ57UVI5UcA1fut2OksQg+g1UHI/Nb0ZdE9TDQ/mZgaoIOBi5GQa+m6WPgcht2qLw+cIWsbIUCbi+YbUMDG5FF7HsL/CMfGX4QlB4JOkg0McxLD/RbamKonh7giyeMIqcL4AjK53bQwD+eAPhiHJoce9Rw82gU0DVk59EosF6NiRmzuoRIgcQpvr9QIteQTab0FmjWVHLz2RQJNOFmW80sQH0sj1LoYWpkXLc+wNELBr6TgwD4rR2GXqkC6JkamBKMADhp2MB3chAAr9TyKRxOwZUReRoLZLXbfpvQPClKIMMUxjewRAaryuEtsCoiu2zwBVhWGD4FGQVsJhijFoUpsIYFA592wAD7QAS/jP4F1EnD1aXBOTW8ehRuQfUr8KvKXABVZxj0dj8C1PPNNIehAOUx2JXwr4CK+X9AIdfQAhZcOIUWQSn8+LP0D3htnx8fMi3MIEszTP025D09Wnp5+43EPbZlSBa80lFVgb9yISjkspBxSGbuIJKMOvsi4y4yOUHCtkjD8n5Ejq/ryYq80/hyvmn+B4msCN67lHFQZO+dqkQkRdPG78ikJnHbCGln1BBJKrrKZEY8r7qC7M6oU7Ofok0jLl6hhmlEaqaUTXn/UTLToEatZl4HaSRfj7Z5M+NqZqIJB629mcRD2IiMy8rNQb7MDk1YViunlyR5VYbNIeO3cvMQCelHhZpBd3wqNcmPaj5dEflSMF63R9C4or6yYlHRhF3QluVQVaeqGsqyDbqwKaLRsgp/XLX9abtHzRbyR8HiLElN3fsEVQ6Hw+FwOBwOh8PxOfwDT/dxGdSpqv0AAAAASUVORK5CYII=" class="img-circle" width="150" />
                                    <h4 class="card-title m-t-10" v-text="form.fullname">Hanna Gover</h4>
                                    <h6 class="card-subtitle">Candidate</h6>
                                    
                                </center>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->
                    <!-- Column -->
                    <div class="col-lg-8 col-xlg-9 col-md-7">
                      <b-tabs>
                        <b-tab title="Profile" active>
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
                        </b-tab>
                        <b-tab title="Questions">
                          <b-table :items="questions" :fields="fields" striped responsive="sm" :busy="isBusy" >
                          <template v-slot:table-busy>
                            <div class="text-center text-dark my-2">
                              <b-spinner class="align-middle"></b-spinner>
                              <strong>Loading...</strong>
                            </div>
                          </template>
                          <template v-slot:cell(answer)="row">
                            <!-- <b-button size="sm" @click="row.toggleDetails" class="mr-2" v-show="!row.item.answer&&isCandidate" v-b-modal.modal-1>
                              Answer Question
                            </b-button> -->
                            <b-button size="sm" @click="row.toggleDetails" class="mr-2" v-show="row.item.answer" >
                              Show Response
                            </b-button>

                            <!-- As `row.showDetails` is one-way, we call the toggleDetails function on @change -->
                          </template>
                          <template v-slot:row-details="row">
                            <b-card>
                              <b-row class="mb-2">
                                <b-col sm="3" class="text-sm-right"><b>Reply:</b></b-col>
                                <b-col>{{ row.item.answer }}</b-col>
                              </b-row>
                            </b-card>
                          </template>

                          
                        </b-table>
                        <b-button variant="secondary" @click="showmodal=true">Ask a Question</b-button>
                        <b-modal id="modal-1" title="Candidate Questions" v-model="showmodal">
                          <b-form-textarea
                            id="textarea"
                            v-model="questionAsked"
                            placeholder="Enter a question..."
                            rows="3"
                            max-rows="6"
                          ></b-form-textarea>
                          <template v-slot:modal-footer>
                          <div class="w-100">
                            <b-button
                              variant="primary"
                              size="sm"
                              class="float-right"
                              @click="askQuestion()"
                            >
                              Submit
                            </b-button>
                            <b-button
                              variant="primary"
                              size="sm"
                              class="float-right mr-2"
                              @click="cancelQuestion()"
                            >
                              Cancel
                            </b-button>
                          </div>
                        </template>
                        </b-modal>
                        </b-tab>
                      </b-tabs>
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
import qApi from '@/apis/questionsApi'
import uApi from '@/apis/userApi'
export default {
  name: "candidateProfile",
  props: {
    msg: String
  },
  data: () => {
    return {
      //activeUser: null,
      fields: ['userID', 'question','answer'],
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
        isSelected: false,
        show: false,
        showmodal: false,
        editable: false,
        canObj: '',
        userObj: '',
        isCandidate: false,
        currentCandidateID:'',
        isBusy: true,
        userProfileComplete: 0,
        items: [
          { isActive: true, Name: "Ben Kenobi", Question: "What happened to quigon?" },
          { isActive: false, Name: "Ben Skywalker", Question: "Where is the droid?", answer: "I don't know" },
          { isActive: true, Name: "Rey", Question: "Who are my parents?" }
        ],
        questions: null,
        questionAsked: null
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
    this.$log.debug("user object: "+this.canObj);
    //  alert(this.$route.params.cID+" is route");
    this.getCandidate(this.$route.params.cID);
    this.$log.debug("Created:"); 

  },

  mounted: function() {
    // this.currentElectionData = this.$route.params.eID
    //   this.getCandidate(this.$route.params.eID);
    this.$log.debug("Mounted:");
    //sets the canObj object from the parent canObj
    this.userObj = this.$parent.$parent.userObj;
    if(this.userObj.type=="Candidate"){
      this.isCandidate=true
    }
    this.$log.debug("Getting questions");
    
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
      this.canObj = response
      this.form.fullname = this.canObj.data.first_name + ' '+ this.canObj.data.last_name
      this.form.fname = this.canObj.data.first_name
      this.form.lname = this.canObj.data.last_name
      this.form.about = this.canObj.data.about
      this.form.education = this.canObj.data.education
      this.form.employment = this.canObj.data.employment
      this.form.experience = this.canObj.data.experience
      this.form.phone = this.canObj.data.contact
      this.getQuestions();
      if(this.canObj!=""){
        this.userProfileComplete = 1
      }else{
        this.userProfileComplete = 0
      } 
      this.show = true;
      })
        .catch(error => {
          this.$log.debug(error);
        });
    },

    enableAnswer: function(){
      this.isSelected=true
    },

    getQuestions: function(){
      qApi.getQuestions(this.canObj.data.canID) .then(response => {
        this.$log.debug("Questions returned: ", response.data)
        this.questions = response.data
        this.isBusy = false
      }
      ) .catch(error =>{
          this.$log.debug(error)
      })

    },

    cancelQuestion: function(){
      this.questionAsked = null
      this.showmodal = false
    },

    askQuestion: function(){
      uApi.askQuestion(this.questionAsked, this.userObj.id, this.canObj.data.canID) .then(response => {
        this.$log.debug("Questions asked: ", response.data)
        this.showmodal=false
      this.isBusy=true
      this.getQuestions()
      }
      ) .catch(error =>{
          this.$log.debug(error)
      })
      
    },
    
   
  }
};
</script>
