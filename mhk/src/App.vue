<template>
  <v-app>
   <v-app-bar absolute color="blue" dark>
    <v-app-bar-nav-icon></v-app-bar-nav-icon>
   </v-app-bar>

    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
  }),
};
</script>
