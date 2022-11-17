<template>
  <div>
  <v-app>
    <!-- <v-app-bar color="deep-purple accent-4" dark><v-app-bar-nav-icon></v-app-bar-nav-icon></v-app-bar> -->
    <v-app-bar absolute color="deep-purple accent-4" dense dark >
      <v-app-bar-nav-icon></v-app-bar-nav-icon>
    </v-app-bar>
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</div>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
};
</script>
