<template>
  <div>
    <h1>Welcome to Home Screen</h1>
    <p>sdglsdhgldshglksdghlskdg</p>
    <!-- 1. Text Interpolation -->
    <!-- 2. Data Binding -->
    <!-- 3. Event Binding -->
    <p class="my-p">{{ userName }}</p>
    <h3>{{ count }}</h3>
    <h3>{{ count == 5 ? "Is 5" : "default" }}</h3>
    <button :disabled="isBtnDisable" @click="countUp()">Count UP</button>
    <MyButtonVue></MyButtonVue>
  </div>
</template>

<script>
import MyButtonVue from "@/components/MyButton.vue";

export default {
  // Screen Name
  name: "home",

  // Use Components
  components: {
    MyButtonVue,
  },

  // Variables
  data() {
    return {
      userName: "Hla Hla",
      count: 0,
      isBtnDisable: false,
    };
  },

  // Run when first open screen
  created() {
    console.log("Opened Home Screen");
  },

  // Methods
  methods: {
    // countUp(num = 0) {
    //   num++;
    //   console.log(num);
    //   return num;
    // },
    countUp() {
      this.count++;
    },
  },
};
</script>

<style scoped>
button {
  padding: 30px;
  color: blue;
  text-decoration: underline;
}

.my-p {
  color: yellow;
  padding: 10px;
}
</style>
