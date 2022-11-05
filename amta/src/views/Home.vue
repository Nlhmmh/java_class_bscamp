<template>
  <div class="wrapper">
    <h1>Welcome to Vue Learning Page</h1>
    <p>UserName: {{ username }}</p>
    <p>Count: {{ count }}</p>
    <p>{{ count !=0  ? "Clicked button!" : "Default count" }}</p>
    <button @click="countUp()" :disabled="isBtnDisabled">Count Up</button>
    <MyButton></MyButton>
  </div>
</template>

<script>
import MyButton from "@/components/MyButton.vue";
export default {
  name: "home",

  components: {
    MyButton,
  },

  data() {
    return {
      username: "Mg Mg",
      count: 0,
      isBtnDisabled: false,
    };
  },

  created() {
    console.log("hello");
  },

  methods: {
    countUp() {
      this.count++;
    },
  },
};
</script>

<style>
.wrapper{
  padding: 20px;
}
button {
  padding: 10px;
  margin: 10px;
  border: 1px solid blue;
  border-radius: 5px;
  color: blue;
}

</style>
