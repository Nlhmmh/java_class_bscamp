<template>
  <div>
    <v-container>
      <v-card class="pa-5 mt-5" elevation="4" max-width="300">
        <v-img
          max-height="250"
          max-width="300"
          src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
        ></v-img>
        <v-card-title class="text-h6">About This Page</v-card-title>
        <v-card-text class="subtitle-1">
            Small plates, salads & sandwiches - an intimate setting with 12
            indoor seats plus patio seating.
        </v-card-text>
        <v-card-actions>
          <v-btn color="primary" elevation="5">See More</v-btn>
          <v-btn disabled elevation="2">disabled</v-btn>
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

<style></style>
