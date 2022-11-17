<template>
  <div>
    <v-container>
        <v-card class="pa-5 mt-10" elevation="4" max-width="300">
            <v-img
            max-height="250"
            max-width="300"
            src="https://images.pexels.com/photos/268533/pexels-photo-268533.jpeg?cs=srgb&dl=pexels-pixabay-268533.jpg&fm=jpg"></v-img>
            <v-card-title>About This Page</v-card-title>
            <v-card-text>Our Shop supports various features ...........</v-card-text>
            <v-card-action>
                <v-btn color="primary" elevation="10">See more</v-btn>&nbsp;
                <v-btn depressed color="error">Error</v-btn>
            </v-card-action>
        </v-card>
        
        <br><br>
        <v-btn class="mx-2" fab dark color="teal">
            <v-icon dark>
             mdi-format-list-bulleted-square
            </v-icon>
        </v-btn>
    </v-container>
  </div>
</template>

<script>
export default {
    name: "about",
}
</script>

<style>

</style>