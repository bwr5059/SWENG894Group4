<template>
    <div>
    <center><h1 class="display-7" >Administrator Help Page</h1></center>

    <div role="tablist">

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-1 variant="info">How to Add a candidate to an Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-1" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            
            <p>To add a candidate to an election, follow the steps below:</p>
            <ul>
              <li>Click on “Search all” on the secondary navigation bar on the homepage.</li>
              <li>Click on an existing election on the election table.</li>
              <li>Click on the “Add Candidate to Election” button.</li>
              <li>Select the Candidate to be added on the modal dialogue.</li>
              <li>Click on submit.</li>
            </ul>
          </b-card-text>
          
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-2 variant="info">How to Delete a Candidate from an election.</b-button>
      </b-card-header>
      <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            <p>To delete a candidate from any given election, follow the steps below:</p>
            <ul>
    <li>Click on “Search all” on the secondary navigation bar on the homepage.</li>
<li>Click on an existing election on the election table.</li>
<li>Click on the name of the candidate you wish to delete from the list of candidates registered for
the election. Then, the “Remove Candidate” button will appear below.</li>
<li>Click on “the “Remove Candidate” button. A confirmation popup will be displayed.</li>
<li>Click on “OK” on the confirmation popup. </li>
</ul>
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-3 variant="info">Can an Election Be Modified After It Has Been Launched?</b-button>
      </b-card-header>
      <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
<p>To maintain the integrity of the election, an election <b>cannot be modified</b> after the election has been
launched. The launch process consists of multiple steps where the election administrator has to confirm
that the election is mistake free (step 2) and confirm that it is understood that the following actions are not
permitted:</p>
<ul>
<li>Add, Edit, or Delete Candidates</li>
<li>Change the election start date</li>
</ul>
If changes have to be made to the election, then the administrator will have to close the election, recreate
it, make the necessary changes to the election, and go through the launch process again. 

        </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

 <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-31 variant="info">How to Manage Voters</b-button>
      </b-card-header>
      <b-collapse id="accordion-31" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            
<p>For an election administrator to manage voters, follow the steps below:</p>
<ul>
<li>Login using username and password (See How to Login under Accounts)</li>
<li>Click on the “Election Admin” button on the secondary navigation bar on the Election
Manager homepage.</li>
<li>Click on the username of the voter you wish to add (to enable him/her to register for an
election) or remove (to prevent him/her from registering for an election). </li>

</ul>
</b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>


        <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-4 variant="info">Election Messages*</b-button>
      </b-card-header>
      <b-collapse id="accordion-4" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
           <p>The election message settings allow the administrator to customize some standard text areas that voters
will see while voting. They are:</p>
<ul>
<li>Registration Message: The registration message contains the authentication key which the user will need to complete his/her
registration to be able to vote in an election.</li>
<li>Vote Confirmation Message: This is the message that voters will see after they cast their vote in an election. The default is: “Thank you
for voting in this election!”</li>
<li>After Election Message: This is the text that the voters will see when they visit your election after it has ended. You can use this
field to post the results of the election or any other generic information you wish to communicate to those
that access your election after it ends. The default is: “Voting for this election has closed! Please contact
your election administrator if you have any questions.”
</li>
</ul>

<p><b>Additional Notes</b></p>

<ul><li>Only an Admin is authorized modify these messages.</li></ul>

          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

        <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-5 variant="info">How to Customize An Election's Email Templates*</b-button>
      </b-card-header>
      <b-collapse id="accordion-5" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            
<p>If the election has emails enabled, then the administrator has the option to customize the content of the
emails that voters will receive. By default, every email to the voters will include the following
information:</p>
<ul>
  <li>The Election name</li>
<li>The voter’s voting credentials (username)</li>
</ul>
<p>To customize the email templates, follow these steps:</p>
<ul>
  <li>Click on the “Settings” button on the secondary navigation bar.</li>
<li>Make sure “Enable Email” is selected</li>
<li>Scroll down and update the content of the email templates</li>
<li>Click “Save” to save the updated settings.</li>
</ul>
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>


        <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-6 variant="info"> How to Set Voting Policy  </b-button>
      </b-card-header>
      <b-collapse id="accordion-6" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            
<p>To set the voting policy, follow these steps:</p>

<ul>
  <li>Click on “Search all” on the secondary navigation bar on the homepage.</li>
<li>Select the election that you want to set a voting policy for from the list.</li>
<li>Click on the set policy button on the election page.</li>
<li>Set the polling type, frequency and whether you would like to enable voters to abstain from voting and write-in candidates.</li>
<li> Click on submit.  </li>
</ul>
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

       

  </div>
    </div>
</template>


<script>
export default {
  name: 'accountHelp',
  props: {
    msg: String
  }
}
</script>