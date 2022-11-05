<template>
  <div>
    <button class="my-btn">Click Me</button>
  </div>
</template>

<script>
export default {
  name: "MyButton",
};
</script>

<style>
.my-btn {
  padding: 20px;
  color: blue;
}

.my-btn :hover {
  color: red;
  text-decoration: underline;
}
</style>
