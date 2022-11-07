<template>
  <div>
    <button class="btn-countup">Click Me</button>
  </div>
</template>

<script>
export default {
    name:"MyButton",
}
</script>

<style>
    .btn-countup{
        color:blue;
    }
    .btn-countup:hover{ 
        cursor:pointer;
        text-decoration: underline;
    }
</style>