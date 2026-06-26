# Poxy
Small mod that mixins into Voxy to make it "work" with Minecraft launchers on Android.

## WARNING
This mod will **NOT** guarantee that Voxy works properly on your device, so please do not report any issues while you are using Poxy.

## What does it do?
- Adds in LWJGL ZSTD and  LWJGL LMDB libraries for Android.
- Makes LMDB the default storage backend for Voxy.
- Makes Voxy use `libc.so` (Android libc) instead of `libc.so.6` (Standard Linux glibc)

## Why?
I was getting tired of having to build Voxy and go through the steps of adding these patches in myself, changing the settings, and creating a Redis server in Termux every time I wanted to try Voxy out on Android.

## License
GNU GPLv3. This mod does not redistribute Voxy.