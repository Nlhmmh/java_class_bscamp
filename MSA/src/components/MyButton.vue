<template>
  <div>
    <button class="mybtn">Click me</button>
  </div>
</template>



<script>
export default {
    name: "MyButton",
} 
</script>



<style>
  .mybtn{
    padding: 50px;
    color: greenyellow;
  }

  .mybtn:hover{
    color: blueviolet;
    text-decoration: line-through;
  }
</style>