<template>
  <div>
    <v-container>
      <h1 class="text-center">Home</h1>
      <h3 class="text-center">Welcome, {{ name }}</h3>
      <v-row class="mt-5">
        <v-col cols="6">
        <v-card width="250" class="my-card">
          <v-img
          src="https://images.unsplash.com/photo-1552549879-7e35b163c03c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8MXx8fGVufDB8fHx8&w=1000&q=80"
          width="250"
          height="350"
          ></v-img>
          <v-card-title>Wallpaper</v-card-title>
          <v-card-subtitle>Beautiful Wallpaper</v-card-subtitle>
        </v-card>
      </v-col>
      <v-col cols="6">
        <v-card width="250" class="my-card">
          <v-img
          src="https://w0.peakpx.com/wallpaper/40/935/HD-wallpaper-nature-beautiful.jpg"
          width="250"
          height="350"
          ></v-img>
          <v-card-title>Wallpaper</v-card-title>
          <v-card-subtitle>Beautiful Wallpaper</v-card-subtitle>
        </v-card>
      </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
    name: "home",

    components: {},

    data() {
      return {
        name: "Mg Mg"
      }
    },
    created() {
      this.showLog();
    },
    methods: {
      showLog() {
        console.log("Home Page is Running.")
      }
    },

}
</script>

<style scoped>
.my-card {
  margin-left: 100px;
}

.my-card:hover {
  background-color: rgb(187, 187, 187);
}

</style>