<template>
  <v-app>
    <v-app-bar absolute color="deep-purple accent-4" dark
      ><v-app-bar-nav-icon></v-app-bar-nav-icon
    ></v-app-bar>
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: "App",

  data: () => ({
    //
  }),
};
</script>
