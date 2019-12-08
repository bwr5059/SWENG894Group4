<template>
    <div>
    <center><h1 class="display-7">Voters Help Page</h1></center>

<div role="tablist">

     <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-0 variant="info">How to View Profile Information</b-button>
      </b-card-header>
      <b-collapse id="accordion-0" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
<p>To view your profile information, do the following:</p>
<ul>
<li>Login using username and password.</li>
<li>Click on username displayed on the top right of the homepage. </li>
</ul>
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

 <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-4 variant="info">How to Update Profile Information</b-button>
      </b-card-header>
      <b-collapse id="accordion-4" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
<p>To change/edit profile information, do the following:</p>
<ul>
<li>Login using username and password.</li>
<li>Click on username displayed on the top right of the homepage.</li>
<li>On profile page, select edit.</li>
<li>Update or edit the information in the visible form fields.</li>
<li>Click on “Submit.”</li>
</ul>
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>


    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-1 variant="info">How to Register to Vote</b-button>
      </b-card-header>
      <b-collapse id="accordion-1" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>

            <p>To register to vote in an upcoming election, follow the steps below:</p>
<ul>


<li>Click on “Search All” on the secondary navigation bar.</li>
<li>Select the election you wish to register for.</li>
<li>Click on the “Register” button.</li>
<li>Enter the “Input Key” provided by the admin in the Modal dialog.</li>
<li>Click on “Verify Election Key”. A pop-up message that the key is authenticated will be displayed.</li>
<li>Click on “OK”. </li>

</ul>
 


          </b-card-text>
          
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-2 variant="info">How to Cast Vote</b-button>
      </b-card-header>
      <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>

<p>To cast a vote in an election, follow these steps:</p>
<ul>
<li>Login using username and password. </li>
<li>Click on “Search All” on the secondary navigation bar. </li>
<li>Click on the election you wish to cast a vote from the list. </li>
<li>View the candidates and instructions for the election. </li>
<li>Click on the candidate you wish to vote for. </li>
<li>Click on “Submit.” </li>
<li>Click on “Yes” on the confirmation pop-up to confirm that you want to submit the Vote. </li>
</ul>
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-3 variant="info">How to Abstain from Voting</b-button>
      </b-card-header>
      <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
            <p>To abstain from voting in an election, follow these steps:</p>
<ul>
<li>Login using username and password.</li>
<li>Click on “Search All” on the secondary navigation bar.</li>
<li>Click on the election you wish to abstain from voting in from the list.</li>
<li>Click on “Abstain from Voting” button.</li>
<li>Click on “Yes” on the confirmation pop-up to confirm that you want to abstain from voting. </li>
</ul>

<p><b>Additional Notes:</b></p>
<ul><li>Once you have casted a vote in an election, you cannot abstain from voting in that election</li></ul>

          </b-card-text>
        </b-card-body>
         </b-collapse>
    </b-card>


    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-30 variant="info"> How to Write in Candidate</b-button>
      </b-card-header>
      <b-collapse id="accordion-30" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
            <p>To vote by writing in a candidate in an election, follow these steps:</p>
<ul>
<li>Login using username and password.</li>
<li>Click on “Search All” on the secondary navigation bar.</li>
<li>Click on the election you wish to vote by writing in a candidate who is not on the list. </li>
<li>Click on “Write In Candidate” button. A modal dialog will appear.</li>
<li>In the modal dialog, type in the first and last name of the candidate you wish to write in.  </li>
<li> Click on “Write In”. A message that you have successfully written in a candidate and casted your
vote will be displayed. </li>
</ul>

<p><b>Additional Notes:</b></p>
<ul><li>Once you have casted a vote in an election, you cannot abstain from voting in that election</li></ul>

          </b-card-text>
        </b-card-body>
         </b-collapse>
    </b-card>

<b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-5 variant="info"> How to Withdraw from An Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-5" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
            <p>Withdrawing from an election, leads to the removal of a registrant’s name from the list of eligible voters.
To withdraw from an election, follow these steps:</p>
<ul>

<li>Login using username and password.</li>
<li>Click on “Search All” on the secondary navigation bar.</li>
<li>Click on the election you wish to withdraw from on the list. </li>
<li>Click on the “Withdraw” button.</li>
<li>Click on “Yes” on the confirmation pop-up to confirm that you want to withdraw from the
election. </li>
</ul>

<p><b>Additional Notes:</b></p>
<ul><li>Once you have casted a vote in an election, you cannot withdraw from that election.</li></ul>

          </b-card-text>
        </b-card-body>
         </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-6 variant="info"> How to Change Vote Casted. </b-button>
      </b-card-header>
      <b-collapse id="accordion-6" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
            <p>A vote can be changed provided that the election has not closed.
To change the vote casted in an election, follow these steps: </p>


<ul>

<li>Login using username and password.</li>
<li>Click on “Search All” on the secondary navigation bar.</li>
<li>Click on the election you wish to change your vote for from the list </li>
<li>Click on the “Change Vote” button.</li>
<li>Click on “Yes” on the confirmation pop-up to confirm that you want to change your vote. </li>
</ul>

<p><b>Additional Notes:</b></p>
<ul><li>Once you have casted a vote in an election, you cannot withdraw from that election.</li></ul>

          </b-card-text>
        </b-card-body>
         </b-collapse>
    </b-card>

        
    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-7 variant="info"> How to View A Candidate’s Profile </b-button>
      </b-card-header>
      <b-collapse id="accordion-7" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
        <p>There are 2 options to view a candidate’s profile.</p>
<p>For the first option, follow these steps:</p>
<ul>
<li>Click on the drop-down select menu on the top right of the homepage, beside the search bar.</li>
<li>Select candidate.</li>
<li>Type the last name of the candidate in the search bar.</li>
<li>Click on “Search” button.</li>
</ul>

<p>For the second option, follow these steps:</p>

<ul>
<li>Click on the “Candidate” button on the secondary navigation bar on the homepage.</li>
<li>Select the candidate whose profile you will like to view from the list. </li>
</ul>
          </b-card-text>
        </b-card-body>
         </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-8 variant="info"> How to Ask a Candidate a Question  </b-button>
      </b-card-header>
      <b-collapse id="accordion-8" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          <p>To ask a candidate a question, follow these steps:</p>
<ul>
  <li>View the candidate’s profile (See How To View A Candidate’s Profile above)</li>
<li>Click on the “Questions” tab on the candidate’s profile page.</li>
<li>Click on the “Ask a Question” button.</li>
<li>Enter the question you will like to ask on the modal dialog.</li>
<li>Click on “Submit”.</li>
        </ul>
          </b-card-text>
        </b-card-body>
         </b-collapse>
    </b-card>


    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-9 variant="info">  How to View A Candidate’s Answered Questions </b-button>
      </b-card-header>
      <b-collapse id="accordion-9" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
    <p> To view a candidate’s answered questions, follow these steps:</p>
<ul>
<li>View the candidate’s profile (See How to View A Candidate’s Profile above)</li>
<li>Click on the “Questions” tab on the candidate’s profile page. If a question has been answered, the “Show Response” button will be displayed on the right, beside the questions asked.</li>
<li>  Click on the “Show Response” button to view the reply. </li>
</ul>
        
          </b-card-text>
        </b-card-body>
         </b-collapse>
    </b-card>


    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-10 variant="info">How to View Progress/Prediction Reports of An Election  </b-button>
      </b-card-header>
      <b-collapse id="accordion-10" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          <p>Vision Election System provides progress and prediction reports for every running election. Only the
voters and candidates have access to the election predictions and progress page. To view the
progress/prediction of a running election, follow the steps below:</p>
<ul>
<li>Click on “Search All” on the navigation bar.</li>
<li>Select the election you wish to view its progress from the list on the election table.</li>
<li>Click on either the “Progress” or “Prediction” button. The progress or prediction chart will be
displayed. </li>
</ul>
        
          </b-card-text>
        </b-card-body>
         </b-collapse>
    </b-card>


    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-11 variant="info"> Error Messages  </b-button>
      </b-card-header>
      <b-collapse id="accordion-11" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
          <p> <b style='color:red' >Error Message: “The provided username does not exist. Please try again.” </b> This error message will only appear If a username does not exist. </p> 
          
<p > <b style='color:red' >Error Message: “You have already voted in this election.”</b> This error message will only appear if a vote has been casted by the given voter.</p>

<p > <b style='color:red' >Error Message: “Voting for this election has closed.”</b> This error message will only appear if the election is no longer active (it is listed as “Completed” in your
election administration interface).</p>

<p  > <b style='color:red' >Error Message: “This election has not started yet. Please try again later.”</b> This error message will only appear if the election has not started (it will be listed as “Scheduled” in your
election administration interface). </p>

        
          </b-card-text>
        </b-card-body>
         </b-collapse>
    </b-card>


    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-12 variant="info"> Browser Issues </b-button>
      </b-card-header>
      <b-collapse id="accordion-12" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
        <p> Most issues a voter may experience will be related to the browser and version they’re using. Election
Runner supports the latest versions of Chrome, Safari, Firefox and Internet Explorer. If you are using the
latest version of a supported browser and continue to experience problems, please contact support. </p>
          </b-card-text>
        </b-card-body>
         </b-collapse>
    </b-card>


    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-13 variant="info">What is a username?  </b-button>
      </b-card-header>
      <b-collapse id="accordion-13" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          <p>Each voter in your election will be assigned a username. Think of it as a User ID. When voting in the
election, the voters will need to enter their username before accessing the election. This ensures that the
election remains private, and that each voter can only cast one vote</p>
        
          </b-card-text>
        </b-card-body>
         </b-collapse>
    </b-card>


    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-14 variant="info"> Can Election Administrators Change a Voter's Vote? </b-button>
      </b-card-header>
      <b-collapse id="accordion-14" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          <p> Once a voter cast his/her vote, he or she can change the vote provided that the election has not closed.
However, an election administrator <b>cannot</b> change a voter’s vote.</p>
        
          </b-card-text>
        </b-card-body>
         </b-collapse>
    </b-card>

        
           <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-15 variant="info"> Can Election Administrators See How a Voter Voted? </b-button>
      </b-card-header>
      <b-collapse id="accordion-15" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>

        <p>By default, election administrators cannot see how a voter voted. The only information the administrator
will have about an individual voter is:</p>
<ul>
<li>The status of the voter (if they have or have not voted). </li>
<li>The date/time the voter logged in to the election. </li>
<li>The date/time the voter submitted his/her vote.  </li>
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
  name: 'votersHelp',
  props: {
    msg: String
  }
}
</script>