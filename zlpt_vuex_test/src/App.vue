<template>
  <v-app>
    <v-main>
      <Heading></Heading>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
import Heading from './components/Heading.vue';

export default {
  name: 'App',
  components: {
    Heading,
  }
};
</script>
