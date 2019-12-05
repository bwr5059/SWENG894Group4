<template>
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
              
                
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h1 class="display-5">Candidate Profile</h1>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- Row -->
                <b-container>
                <div>
                  <div class="d-flex justify-content-center mb-3">
                    <b-spinner v-if="!show" label="Loading..."></b-spinner>
                  </div>
                </div>
                </b-container>
                <b-container v-if="show">
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
                                                  disabled
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
                                                  disabled
                                                   ></b-form-input>
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">contact No</label>
                                        <div class="col-md-12">
                                              <b-form-input
                                                  id="input-4"
                                                  class="form-control form-control-line"
                                                  v-model="form.contact"
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
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                             <b-button v-show="!editable" v-on:click="edit">Edit</b-button>
                                             <b-button v-show="editable" class="mr-1" v-on:click="cancel">Cancel</b-button>
                                             <b-button v-show="editable" v-on:click="addUser">Submit</b-button>
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
                          <template v-slot:cell(name)="data">
                          {{data.item.first_name}} {{data.item.last_name}}
                          </template>
                          <template v-slot:cell(answer)="row">
                            <b-button size="sm" @click="showModal(row.index, row.item.question)" class="mr-2" v-show="!row.item.answer">
                              Reply
                            </b-button>
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
                        <b-modal id="modal-1" :title="modalTitle" v-model="showmodal">
                          <b-form-textarea
                            id="textarea"
                            v-model="qResponse"
                            placeholder="Enter a response"
                            rows="3"
                            max-rows="6"
                          ></b-form-textarea>
                          <template v-slot:modal-footer>
                          <div class="w-100">
                            <b-button
                              variant="primary"
                              size="sm"
                              class="float-right"
                              @click="answerQuestion(currentQIndex)"
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
                </b-container>
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
</template>

<script>
import api from '@/apis/candidateApi'
import qApi from '@/apis/questionsApi'

export default {
  name: 'candidateProfile',
  props: {
    msg: String,
    //activeUser: Object
  },
  data: () => {  
      return {  
          //canID, userID, first_name, last_name, email, electionID, about, education, employment, experience, contact
        activeUser: null,
        form: {
          canID:'',
          userID:'',  
          email:'',  
          electionID:'',  
          fullname:'',
          lastname:'',
          fname: '',
          lname: '',
          about: '',
          education: '',
          employment: '',
          experience: '',
          contact: ''         
        },
        editableLastName:false,
        show: false,
        editable: false,
        userObj: '',
        userProfileComplete: 0,
        fields: ['name', 'question','answer'],
        isBusy: true,
        questions: null,
        qResponse: null,
        showmodal: false,
        currentQuestion: '',
        currentQIndex: ''
      }  
    },  

  
    computed: {
    
    modalTitle(){
    return this.currentQuestion;
    }},
    mounted: function(){
    this.activeUser = this.$parent.activeUser,
    this.$log.debug(this.activeUser.family_name)
    api.getCandidateByName(this.activeUser.family_name)  
    .then(response => {  
      this.$log.debug("Candidate Profile loaded: ", response)
      this.userObj = response
      this.form.fullname = this.activeUser.given_name + ' '+ this.activeUser.family_name
      this.form.fname = this.activeUser.given_name
      this.form.lname = this.activeUser.family_name
      this.form.lastname = this.userObj.data.last_name
      this.form.about = this.userObj.data.about
      this.form.education = this.userObj.data.education
      this.form.employment = this.userObj.data.employment
      this.form.experience = this.userObj.data.experience
      this.form.contact = this.userObj.data.contact
      this.show=true
      this.getQuestions();
      if(this.userObj.data.canID){
        this.userProfileComplete = 1
      }else{
        this.userProfileComplete = 0
      } 
  })
      
    },

     async created () {  
    await this.refreshActiveUser()  
    // this.form.email = this.activeUser.email,
    // this.form.fname = this.activeUser.given_name,
    // this.form.lname = this.activeUser.family_name
  },  
  
  watch: {  
    '$route': 'refreshActiveUser'  
  },  
  
  methods: {  
    async refreshActiveUser () {  
      this.activeUser = await this.$auth.getUser()  
      this.$log.debug('activeUser',this.activeUser)
      
    },  
  
    async handleLogout () {  
      await this.$auth.logout()  
      await this.refreshActiveUser()  
      this.$router.go('/')  
    },

    edit: function(){
    
    this.editable=true

    },

    cancel: function(){
    
    this.editable=false

    },

    addUser: function () {  
        
    if(this.userProfileComplete==0){
    api.addCandidate(this.activeUser.sub,this.userObj.data.id, this.form.fname, this.form.lname, this.activeUser.email, this.form.electionID, this.form.about, this.form.education, this.form.employment, this.form.experience, this.form.contact).then( (response) => {  
      this.$log.debug("New User created:", response); 
      alert("Candidate Profile Created") 
      this.$router.push({ path: '/app/user/home' })
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to add todo"  
    });  }
    else{
    
    //update the user
    //fname, lname, about, education, employment, experience, contact
    api.modifyCandidate(this.activeUser.sub, this.activeUser.sub, this.form.fname, this.form.lastname, this.activeUser.email, "", this.form.about, this.form.education, this.form.employment, this.form.experience, this.form.contact).then( (response) => {  
      this.$log.debug("User Updated:", response); 
      alert("Profile Updated")
      this.$router.push({ path: '/app/user/home' })
    }).catch((error) => {  
      this.$log.debug(error);  
      this.error = "Failed to add todo"  
	});
      
  }
  
   
  },  
  getQuestions: function(){
      qApi.getQuestions(this.userObj.data.canID) .then(response => {
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
  
    answerQuestion: function(index){
      api.answerQuestion(this.qResponse,this.questions[index].qID ) .then(response => {
        this.$log.debug("Questions answered: ", response.data)
        this.showmodal = false
        this.isBusy = true
        this.getQuestions()
      }
      ) .catch(error =>{
          this.$log.debug(error)
      })

    },

    showModal: function(index, question){
      this.showmodal=true
      this.currentQIndex = index
      this.currentQuestion = question
    }


  
  },
}


</script>