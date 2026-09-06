# GPU Compatibility Table

This table tracks the compatibility of Voxy across different GPUs, and the renderers used to make it work.

| GPU         | Zink	        | PR # |
|-------------|-------------|------|
| Adreno 840  | ✅ (Turnip) | 
| Adreno 830  | ✅ (Turnip) | 
| Adreno 750  | ❌ (Turnip) | 
| Adreno 740  | ❌ (Turnip) | 
| Xclipse 960 | ✅          | 

### Legend

✅: Graphical errors can not be seen\
\*: LODs render, but there are graphical errors\
?: Has not been tested\
❌: Does not render LODs or crashes

## Contributing
You may contribute to this table by adding more rows with the GPU you tested on, but some guidelines first:
* Follow the format and use the legend accordingly.
* Do not modify other rows unless you are updating them (and if you are, add your PR # after the original, like `#2, #3`)
* Attach images of the game running with Voxy to your PR with the debug screen (F3) open.
