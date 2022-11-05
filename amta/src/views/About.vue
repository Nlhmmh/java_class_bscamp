<template>
  <div class="about">
    <h1>This is an about page</h1>
    <v-container>
      <v-card class="pa-5" elevation="4" max-width="300">
        <v-img
          height="250"
          src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
        >
        </v-img>
        <v-card-title class="text-h6">About page </v-card-title>
        <v-card-text class="subtitle-1"
          >Testing vuetify components....
        </v-card-text>
        <v-card-actions>
          <v-btn elevation="10" color="primary">See more</v-btn>
          <v-btn disabled>Disable</v-btn>
        </v-card-actions>
      </v-card>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "about",
};
</script>
