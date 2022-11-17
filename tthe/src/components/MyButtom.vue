<template>
  <div>
    <button class="my-button">Click Me</button>
  </div>
</template>

<script>
export default {
    name: "MyButton",
}
</script>

<style>
    .my-button{
        padding: 30px;
        color: blue;
        
    }

   .my-button:hover{
        text-decoration: underline;
    }
</style>