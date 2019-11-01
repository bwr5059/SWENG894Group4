<template>
<div>
View Candidate Profile
<router-view></router-view>
</div>
</template>

<script>
export default {
  name: 'viewCandidate',
  props: {
    msg: String
  }
}
</script>
