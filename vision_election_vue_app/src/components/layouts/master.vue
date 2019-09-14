<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="/">VisionElection</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/about">About</a>
          </li>
        </ul>
        
        <a href="/register" class="btn btn-outline-success my-2 my-sm-0 mr-1" role="button">Register</a>
        <a href="/login" class="btn btn-outline-success my-2 my-sm-0 mr-1" role="button">Login</a>
      </div>
    </nav>
      <router-view></router-view>
  </div>
</template>

<script>
import landing from '@/components/marketing/landing.vue'
export default {
  name: 'master',
  components: {
    landing
  },
  props: {
    msg: String
  }
}
</script>
