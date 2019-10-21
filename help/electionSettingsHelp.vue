<template>
    <div>
    <center><h1 class="display-7">Election settings Help Page</h1></center>


    <div role="tablist">
    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-1 variant="info">How to Delete an Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-1" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
          <p>To delete an election the administrator must, 
          open the election that he/she want to delete and follow the steps below:</p>
     <ol>
<li>Click on “Settings” on the election sidebar.</li>
<li>Click on the “Delete” link on the election settings navigation.</li>
<li>Click the “Delete Election” button and click “Yes” to confirm.</li> 
    </ol>     
           <p><b>Additional Notes</b></p>
    <ul>
<li>Only an administrator can delete an election.</li>
<li>Deleting an election that is in the “Running” state will result in the election closing immediately.</li>
<li>Once deleted, elections cannot be recovered. This action is not reversible.</li>
    </ul>     
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-2 variant="info">How to Update an Election's Start/End Date</b-button>
      </b-card-header>
      <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
          <p>You can update your election’s start/end date by following the steps below:</p>
     <ol>
<li>Click on “Settings” on the election sidebar.</li> 
<li>Click on the “Dates” link.</li>  
<li>In the right pane, select the timezone, the start date/time and the end date/time.</li> 
<li>Click “Save” to update your election’s date settings.</li> 
     </ol> 
          <p><b>Additional Notes</b></p>
     <ul>
<li>The election’s end date/time must be after the start date/time.</li>
<li>Elections will not automatically start on the start date without going through the “Launch” process.</li>
<li>If the start date/time is set to a time in the past, then the election will start within 1 minute on completion of the launch process.</li>
     </ul>

          
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-3 variant="info">How to Display a Confirmation Dialog to Voters when Submitting a Ballot</b-button>
      </b-card-header>
      <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
          <p>Enable the “Submit Ballot Confirmation” option in your election settings to show a 
          confirmation dialog to voters when they submit their ballot. The voter has the option to “Cancel” 
          and make changes to their ballot or they can click “Yes” to submit their ballot.</p>
          <p>You can customize the dialog message or leave it blank for the default message: 
          “Are you sure you want to submit your ballot?”.</P>
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

<b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-4 variant="info">How to Enable the Vote Confirmation Dialog</b-button>
      </b-card-header>
      <b-collapse id="accordion-4" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
     <ol>
<li>Click on “Settings” on the election sidebar.</li>
<li>Click on the “Voters” link on the election settings navigation.</li>
<li>Click the toggle in the “Submit Ballot Confirmation” section to enable it.</li>
<li>You can provide an optional message to override the default message “Are you sure you want to submit your ballot?”.</li>
<li>Click “Save” Election Results Settings.</li>
    </ol>     
          
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-5 variant="info">How To Edit your Election’s Results Settings</b-button>
      </b-card-header>
      <b-collapse id="accordion-5" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>

     <ol>
<li>Click on “Settings” on the election sidebar.</li>
<li>Click on the “Results” link on the election settings navigation.</li> 
     </ol>     
          <p><b>Additional Notes</b></p>
     <ul>
<li>The results settings cannot be updated after the election has launched.</li>
<li>Election administrators have the ability to publish the results of an election once the election has completed.</li>
     </ul>     
          
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-6 variant="info">Election Messages</b-button>
      </b-card-header>
      <b-collapse id="accordion-6" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          <p>The election message settings allow you to customize 
          some standard text areas that voters will see while voting.</p>
     <ol>
<li>Login Message</li>
<li>Vote Confirmation Message</li>
<li>After Election Message</li>
     </ol>   
           <p><b>1. Login Message</b></p>
           <p>The login message shows up on the voter login form. You can use this area to provide login instructions to voters. 
           There is no default value for this field.</p>  

           <p><b>2. Vote Confirmation Message</b></p>
           <p>This is the message that voters will see after the submit their ballot.</p>
           <p><b>Default:</b> “Thank you for voting in this election!”</p>

           <p><b>3. After Election Message</b></p>
           <p>This is the text that your voters will see when they visit your election after it has ended. 
           You can use this field to post the results of the election or any other generic information you wish to 
           communicate to those that access your election after it ends.</p>
           <p><b>Default:</b> “Voting for this election has closed! Please contact your
            election administrator if you have any questions.”</p>
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>



    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-7 variant="info">How to Close an Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-7" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          <p>Elections that are in the “Running” state will automatically end on the end date/time set 
          in the election settings. If you would like to manually close your election, 
          then follow the steps below:</p>
     <ol>
<li>Click on “Settings” on the election sidebar.</li>
<li>Click on the “Close Election” link on the election settings navigation.</li>
<li>Click the “Close Election” button and click “Yes” to confirm.</li> 
<li>You should be redirected to the new election page.</li>
    </ol> 
          <p><b>Additional Notes</b></p>
     <ul>
<li>Elections can only be closed if they’re in the “Running” state</li>
<li>Voters in the process of voting will not be able to submit their vote</li>
<li>Voters will not be able to login to the election once it has been closed</li>
<li>Once an election has ended it cannot be re-opened without contacting support.</li>
     </ul>
          
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-8 variant="info">How to Customize Your Election's Email Templates To Voters</b-button>
      </b-card-header>
      <b-collapse id="accordion-8" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
          <p>If your election has emails enabled, then you have the option to customize the 
          content of the emails that voters will receive. By default, 
          every email to your voter will include the following information:</p>
     <ul>
<li>The state’s name.</li>
<li>The voter’s voting credentials (Voter ID).</li>
     </ul>     
           <p>To customize the email templates, follow these steps:</p>
     <ol>
<li>Click on “Settings” on the election sidebar.</li>
<li>Click on the “Email” link on the election settings navigation.</li>
<li>Make sure “Enable Email” is selected.</li>
<li>Scroll down and update the content of the email templates.</li> 
<li>Click “Save” to save the updated settings.</li>
     </ol> 
           <p><b>Variable Substitution</b></p>
           <p>Right now, the only possible variable substitution is for the voter’s name. 
           You can use %name% in the email’s body to substitute the Voter’s name.</p>     

          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-9 variant="info">How to Duplicate an Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-9" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
          <p>Duplicating an election makes it easy to start a new election from a test election. 
          This process copies over the following information into a new election titled: “(COPY)” </p>
     <ul>
<li>Election’s Name</li>
<li>Election Settings</li>
<li>Ballot</li>
<li>Voters</li>
    </ul>   
          <p>To duplicate an election, open the election that you would like to duplicate:</p>
     <ol>
<li>Click on “Settings” on the election sidebar.</li>
<li>Click on the “Duplicate” link on the election settings navigation.</li>
<li>Click the “Duplicate Election” button. This process can take up to 15 seconds depending on the size of the election.</li> 
<li>You should be redirected to the new election.</li>
     </ol>  
          <p><b>Additional Notes</b></p> 
     <ul>
<li>In some rare cases duplicating an election may fail due to the size of the ballot.</li> 
<li>Election Add-ons are not copied over when duplicating an election.</li>
     </ul>         
          
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>


    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-10 variant="info">How to Extend an Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-10" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
          <p>To extend an election that is currently in the 
          “Running” state you simply change the election’s end date in the election’s settings. Here’s how:</p>
     <ol>
<li>Click on “Settings” on the election sidebar.</li>
<li>Click on the “Dates” link on the election settings navigation.</li>
<li>Click the “End Date” input field to open the date/time picker.</li>
<li>Select the new end date and time of the election.</li>
<li>Click “Set End Date”.</li>
<li>Click “Save” and confirm that the new end date/time is correct.</li> 
     </ol>   
          <p><b>Additional Notes</b></p> 
     <ul>
<li>To extend an election that has already ended, please contact support. Please take note of our support window.</li>
     </ul>      
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-11 variant="info">Results</b-button>
      </b-card-header>
      <b-collapse id="accordion-11" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          <p><b>Can Election Administrators Change a Voter's Vote?</b></p>
          <p>Once a voter submits their ballot it cannot be changed by the voter or an election administrator. By default, 
          election administrators cannot see how an individual voter voted.</p>
          <p><b>Voter Audit Report</b></p>
          <p>The voter audit report allows you to view technical details for each 
          voter that voted in your election. 
          It includes the following fields:</p>
     <ul>
<li>Voter Name</li>
<li>Voter ID</li>
<li>IP Address</li>
<li>User Agent (browser identifying information)</li>
<li>Vote Date/Time (UTC Time)</li>
     </ul>   
           <P><b>How to Download the Voter Audit Report:</b></p> 
     <ol>
<li>Click on “Results” on the election sidebar.</li>
<li>Click on the “Download” button at the top right of the page.</li>
<li>Select “Voter Audit” from the dropdown menu. A CSV file that can be opened in Microsoft Excel or Google Spreadsheets will be downloaded to your device.</li>
     </ol>  
           <p><b>Can Election Administrators See How a Voter Voted?</b></p>
           <p>By default, election administrators cannot see how a voter voted. 
           The only information the administrator will have about an individual voter is:</p>     

          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-12 variant="info">Accordion 12</b-button>
      </b-card-header>
      <b-collapse id="accordion-12" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>{{ text }}</b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

  </div>



    </div>
</template>


<script>
export default {
  name: 'electionSettingsHelp',
  props: {
    msg: String
  }
}
</script>