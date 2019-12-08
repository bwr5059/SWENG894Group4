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
          
          <p>To delete an election from your account, open the election that you want to delete and follow the steps
below:</p>
     <ul>
<li>Click on “Search All” on the navigation bar</li>
<li>Select the election you wish to delete from the list on the election table</li>
<li>Click the “Delete Election” button and click “Yes” to confirm.</li> 
    </ul>     
          <p><b>Additional Notes</b></p>
<ul>
<li>Only an Admin is authorized to delete an election.</li>
<li>Deleting an election that is in the “Running” state will result in the election closing immediately.</li>

<li>Once deleted, elections cannot be recovered. This action <b>is not</b> reversible.</li>
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
     <ul>
<li> Click on “Search All” on the navigation bar.</li>
<li>Select the election you wish to update from the list on the election table.</li>
<li>Click on “Edit”.</li>
<li>Select the desired date(s).</li>
<li>Click on submit. </li>
</ul>

     
          <p><b>Additional Notes</b></p>
     <ul>
<li>The election’s end date/time must be after the start date/time.</li>
<li> Elections will <i>automatically start</i> on the start date.</li>
     </ul>

          
          
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-3 variant="info">How to Duplicate an Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
          
          <p>Duplicating an election makes it easy to start a new election from a test election. This process copies over
the following information into a new election with the following duplicates:</p>
          <ul>
            <li>  Election’s Name</li> 
<li>Election Description</li> 
<li> Election Settings</li> 
<li> Candidates</li> 
<li> Voters</li> 
<li> Start Date</li> 
<li> Close Date</li> 
            </ul>

<p>To duplicate an election, open the election that you would like to duplicate…</p>
  <ul>
  <li>  Click on “Search All” on the navigation bar.</li>  
<li>  Select the election you wish to update from the list on the election table.</li>  
<li>  Click on “Duplicate Election” button on the page of the existing election, to create a new election
with the same voters list, candidates and settings.</li>  
<li>  Click on “Yes” on the confirmation popup.</li>  
<li>  Modify the election with the necessary changes.</li>  
<li>  Click on the “Delete” button on the existing election you desired to modify.</li>  
</ul>
<p><b>Additional Notes</b> </p>
<ul><li>  Election Add-ons are not copied over when duplicating an election.</li> </ul>

          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

<b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-4 variant="info">How to Extend an Election</b-button>
      </b-card-header>
      <b-collapse id="accordion-4" visible accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>
   <p>To extend an election that is currently in the “Running” state you simply change the election’s end. See
“How to Update an Election's Start/End Date” above.</p>
<p> <b>Additional Notes</b></p>
<ul>
<li>Only an admin is authorised to extend the date of an election.</li>
<li>To extend an election that has already ended, please contact support. Please take note of our
support window.</li>
    </ul>      
          </b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block href="#" v-b-toggle.accordion-5 variant="info">How to View an Election’s Results</b-button>
      </b-card-header>
      <b-collapse id="accordion-5" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text>

    <p>To publish the results of your election it must be in the “Completed” state.</p>
<ul>
<li>Click on “Search All” on the navigation bar.</li>
<li>Select the election you wish to view its result.</li>
<li>Click on the “Result” button. The election’s result will be displayed.</li>
</ul>
<p><b>Additional Notes:</b></p>
<ul>
<li>Once results have been displayed, it cannot be altered. </li>
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
  name: 'electionSettingsHelp',
  props: {
    msg: String
  }
}
</script>