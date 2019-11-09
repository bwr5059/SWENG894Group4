<template>
    <div>
   <!-- Contact Us Section -->
<section >
    <div class="container">

       
    <div>

<div class="row slideanim slide">
    
    <div class="col-sm-4">
      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSP9sLzIkLUK6kh5LNmhK9vIfKFJnM4CanM-x4zg9mV0TCTVtrwtQ&s" class="img-circle person" alt="Random Name" width="100" height="100">
      <h4>SECURITY</h4>
      <p>We provide third party audits...</p>
      <p> <a  href="#" v-on:click="showmodal1=true"> Click to read more</a></p>
      <b-modal id="modal-3" title="SECURITY" v-model="showmodal1">
            <b-card>
              We provide third party audits & certifications, voter-verified results and 100% availability guarantee.
            </b-card>
          <template v-slot:modal-footer>
              
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right mr-2"
                  @click="showmodal1=false"
                >
                Close
                </b-button>
              
            </template>
        </b-modal>

      </div>
    <div class="col-sm-4">
      <img src="data:image/jpeg;base64,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" class="img-circle person" alt="Random Name" width="100" height="100">
      <h4>CREDIBILITY</h4>
      <p>With Vision Election there will..</p>
      <p> <a  href="#" v-on:click="showmodal2=true"> Click to read more</a></p>
      <b-modal id="modal-3" title="CREDIBILITY" v-model="showmodal2">
            <b-card>
              With Vision Election there will be anonymity with regards to who a voter voted for
               and the system will collate votes and display information quickly. It also helps 
               to eliminate human error in the vote-counting process, ensuring that the result of any 
               election is 100 percent accurate. You can also see how many people have voted to ensure
                that all the responses have been received. The alternative of paper voting is not only far 
                slower but can also put a huge amount of pressure on vote counters which is how errors can creep in.
            </b-card>
          <template v-slot:modal-footer>
              
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right mr-2"
                  @click="showmodal2=false"
                >
                Close
                </b-button>
              
            </template>
        </b-modal>

    </div>

    <div class="col-sm-4">
      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTD0_70gI8OWlMxXoS8_6rhZsyAVq8jQ6xzPeLEX79uTurBGT-gyg&s" class="img-circle person" alt="Random Name" width="100" height="100">
      <h4>TRANSPARENCY</h4>
      <p>We understand that public oversight..</p>
      <p> <a  href="#" v-on:click="showmodal3=true"> Click to read more</a></p>
      <b-modal id="modal-3" title="TRANSPARENCY" v-model="showmodal3">
            <b-card>
              We understand that public oversight starts with transparency in voting; 
              election transparency is the public ability to see and verify each essential step in elections.
               Therefore, Vision Election ensures transparency in four items which are the key to public accountability
                in elections and they are: with regards to who can vote (voters list) but not who they voted for; 
                 who did vote (poll list, or participating voter list);  counting of the vote; and chain of custody.
            </b-card>
          <template v-slot:modal-footer>
              
                <b-button
                  variant="primary"
                  size="sm"
                  class="float-right mr-2"
                  @click="showmodal3=false"
                >
                Close
                </b-button>
              
            </template>
        </b-modal>

    
    </div>
  </div>
    </div>

<div class="row" style="margin-top:50px">
</div>
        <div class="row">
            <!-- Section Titile -->

            <div class="col-md-12" >
                <h1 class="section-title display-7">Contact/Support Page</h1>
            </div>
        </div>

   

        <div class="row">
            <!-- Section Titile -->
            <div class="col-md-6 ">
              <p>
                  From secure polling software to the management of complex voting events - we offer a range of eVoting solutions
                   that exceed expectation. With Vision Election system, you will get a reliable voting process with trustworthy 
                   results. We provide the documentation needed to be transparent for high-level legal and regulatory requirements. 
                   The analytics show how the votes unfold and detailed reporting options allow the outcomes to be shared with
                    interested parties. Never again worry about people voting twice or other forms of vote manipulation because
                     Vision Election specializes in secure, country-wide voting and has built a reputation for delivering excellent
                      service and solid technology. 
              </p>

              <div>
               Company:  Vision Election
              </div>
              <div >
               Address: 1111 Lawrence Kylie Brent St <br/> 
               &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
               IF  TX 12345
              </div>
              <div>
                Phone:  +333-444-5555
              </div>
              
              <div >
                Website:  <a href="#"> www.visonelection.ro</a>
              </div>
              <div >
                 Office Hours: Mon to Sat: 09:30 AM - 10.30 PM
              </div>
            </div>
            <!-- contact form -->
            <div class="col-md-6 " >
                <form  data-toggle="validator">
                    <!-- Name -->
                    <div class="form-group label-floating">
                      <label class="control-label" for="name">Name</label>
                      <input class="form-control" id="name" v-model="name" type="text" name="name" required data-error="Please enter your name">
                      <div class="help-block with-errors"></div>
                    </div>
                    <!-- email -->
                    <div class="form-group label-floating">
                      <label class="control-label" for="email">Email</label>
                      <input class="form-control" id="email" v-model="email" type="email" name="email" required data-error="Please enter your Email">
                      <div class="help-block with-errors"></div>
                    </div>
                    <!-- Subject -->  
                    <div class="form-group label-floating">
                      <label class="control-label">Subject</label>
                      <input class="form-control" id="msg_subject" v-model="subject" type="text" name="subject" required data-error="Please enter your message subject">
                      <div class="help-block with-errors"></div>
                    </div>
                    <!-- Message -->
                    <div class="form-group label-floating">
                        <label for="message" class="control-label">Message</label>
                        <textarea class="form-control" rows="3" v-model="message" id="message" name="message" required data-error="Write your message"></textarea>
                        <div class="help-block with-errors"></div>
                    </div>
                    <!-- Form Submit -->
                    <div class="form-submit">
                        <button class="btn btn-danger " type="submit" id="form-submit"  v-on:click="sendEmail" >Send Message</button>
                        <div id="msgSubmit" class="h3 text-center hidden" ></div>
                        <div class="clearfix"></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
  

    </section>
    </div>
</template>


<script>
export default {
  name: 'cpntact',
  props: {
    msg: String
  },
   data: () => {  
      return {  
         showmodal1: false,
        showmodal2: false,
        showmodal3: false,
        name:'',
        email:'',
        subject:'',
        message:''
      }
   },
  methods: {

      sendEmail: function(){
     
        if(this.name==''){
          alert('Name is required')
        }else if(this.email==''){
          alert('Email is required')
        }else if(this.subject==''){
          alert('Subject is required')
        }else if(this.message==''){
          alert('Message body is required')
        }else{
          alert("Your message was submitted and will be responded to as soon as possible. Thank you for contacting us.")
        }
        
    
    }
      }
}
</script>