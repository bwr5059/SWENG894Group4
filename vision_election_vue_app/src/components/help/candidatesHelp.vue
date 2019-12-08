<template>
    <div>
    <center><h1 class="display-7">Candidate Help Page</h1></center>

 <div role="tablist">
    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-1 variant="info">How to Register as A Candidate in An Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-1" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          
          <b-card-text>
<p>To register as a candidate in an upcoming election, follow these steps:</p>
<ul>
  <li>Click on “Search All” on the secondary navigation bar.</li>
<li>Select the election you wish to register for.</li>
<li>Click on the “Register” button.</li>
<li>Enter the “Input Key” provided by the admin in the Modal dialog.</li>
<li>Click on “Verify Election Key”. A pop-up message that the key is authenticated will be displayed.</li>
<li>Click on “OK”. Your name will be displayed on the list of registered candidates.</li>
</ul>
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-2 variant="info"> How to View Profile Information  </b-button>
      </b-card-header>
      <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            <p>There are 2 options to view a candidate’s profile.</p>
<p>For the first option, follow these steps:</p>
<ul>
<li>Click on the drop-down select menu on the top right of the homepage, beside the search bar.</li>
<li>Type in your last name in the search bar.</li>
<li>Click on “Search” button.</li>
</ul>
<p>For the second option, follow these steps:</p>
<ul>
<li>Click on the “Candidate Profile” button on the secondary navigation bar on the homepage.</li></ul>

          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-3 variant="info">  How to Update Profile Information </b-button>
      </b-card-header>
      <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            <p>To change/edit profile information, do the following:</p>
<ul>
<li>View your profile (See How to View Profile Information above).</li>
<li>Click on “Edit” button at bottom of the profile page.</li>
<li>Update or edit the information in the visible form fields.</li>
<li>Click on “Submit.”</li>
</ul>
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-4 variant="info">  How to Withdraw Candidacy from Election </b-button>
      </b-card-header>
      <b-collapse id="accordion-4" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            <p>There are 2 options for a candidate to withdraw from an election.</p>
<p>For the first option, follow these steps:</p>
<ul>
<li>Login using Candidate ID and password.</li>
<li>Click on the drop-down select menu on the top right of the homepage, beside the search bar.</li>
<li>Select “Election”.</li>
<li>Type in the Election ID in the search bar.</li>
<li>Click on “Withdraw” button.</li>
<li>Click on “Yes” on the confirmation pop-up.</li>
</ul>
<p>For the second option, follow these steps:</p>
<ul>
<li>Click on “Search All” on the secondary navigation bar.</li>
<li>Select the election you wish to withdraw from.</li>
<li>Click on the “Withdraw” button.</li>
<li>Click on “Yes” on the confirmation pop-up. </li>
</ul>
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-5 variant="info"> How to Answer a Question. </b-button>
      </b-card-header>
      <b-collapse id="accordion-5" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
            <p>To answer a question, follow these steps</p>
<ul>
<li>View your profile (See How to View Profile Information above).</li>
<li>Click on the “Question” tab on your profile page.</li>
<li>Click on the “Reply” button beside the question you want to answer.</li>
<li>Type in your reply in the modal dialog.</li>
<li>Click on “Submit”.</li>

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
  name: 'candidateHelp',
  props: {
    msg: String
  }
}
</script>