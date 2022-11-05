<template>
  <div>
    <v-app-bar
    elevation="4"
    dense
    
    >
    <router-link to="/" class="mx-2 navlink">Home</router-link>
    <!-- <v-spacer></v-spacer> -->
    <router-link to="/about" class="mx-2 navlink">About</router-link>
    </v-app-bar>
  </div>
</template>

<script>
export default {
 name: "header",

}
</script>

<style scoped>

.navlink {
  text-decoration: none;
}
.navlink:hover {
    text-decoration: underline;
}

</style>