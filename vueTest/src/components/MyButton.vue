<template>
  <div>
    <button class="my-btn">Click Me</button>
  </div>
</template>

<script>
export default {
    name: "MyButton",
}
</script>

<style>
.my-btn {
    padding: 20px;
    color: green;
    font-weight: bold;
}

.my-btn:hover{
    text-decoration: underline;
    font-size: 20px;
}

</style>