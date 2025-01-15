# Stonecutter template

This template allows you create multiloader multitemplate mod using stonecutter and architectury 

It is based on my CustomCursor project

To change versions check settings.gradle.kts

You can use c# script to automatically change all template names.
Open RenameTemplate.cs, change names in replacements array and run "dotnet run" in this directory
I would highly recommend to do this before opening project in your IDE, and then remove all c# related files from project
(obj and bin folders, .csproj and script itself). Also you can remove c# stuff from .gitignore (there is comment for that)

If you have some issues with template ping me in [Kiku's realm](https://discord.gg/TBgNUCfryS) or official fabric discord

Currently supported versions these,
but you can easily add other versions if you need that
- 1.20.1, fabric, lexforge
- 1.20.4, fabric, neoforge
- 1.21.1, fabric, neoforge
- 1.21.3, fabric, neoforge
- 1.21.4, fabric, neoforge

Also template had publishing set up, you need to specify project id for modrinth and curseforge in gradle.properties, and tokens for these sites in local.properties (it is gitignored, check local.properties.example) 