<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header class="app-nav">
      <div class="logo-container">
        <img src="@/assets/app-icon.png" alt="Logo" class="logo" />
        <h1 class="app-name">Data Sculpthor</h1>
      </div>
      <nav class="buttons-container">
        <RouterLink to="/">
          <button >
            Home
          </button>
        </RouterLink>
        <RouterLink to="/Saved">
          <button >
            Save
          </button>
        </RouterLink>
      </nav>
        <div class="user-container">
          <span class="username">Angel Brand</span>
          <img src="@/assets/user-icon.png" alt="User Icon" class="user-icon" />
        </div>
    </header>
  <div class="content-view">
    <RouterView />
  </div>
</template>

<style scoped>
.content-view{
  height: calc(100% - 91px);
  width: 100%;
}
.app-nav {
  background-color: #4285f4;
  color: #ffffff;
  padding: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo-container {
  display: flex;
  align-items: center;
}

.logo {
  width: 40px;
  height: 40px;
  margin-right: 10px;
}

.app-name {
  font-size: 1.5rem;
}

.buttons-container {
  display: flex;
}

button {
  margin-right: 10px;
  padding: 8px 16px;
  background-color: #ffffff;
  color: #4285f4;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.user-container {
  display: flex;
  align-items: center;
}

.username {
  margin-right: 10px;
}

.user-icon {
  width: 60px;
  height: 60px;
}
</style>
