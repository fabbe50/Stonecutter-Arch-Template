
public static List<string> FindAllFiles(string directoryPath)
{
    return Directory.GetFiles(directoryPath, "*.*", SearchOption.AllDirectories).ToList();
}

var replacements = new[]
{
    new { Old = "com.example", New = "io.github.cooldev" },
    new { Old = "template", New = "coolmod" },
    new { Old = "Template", New = "Cool Mod" },
    new { Old = "TempLate", New = "CoolMod" }
};

var files = FindAllFiles(Directory.GetCurrentDirectory());

foreach(var file in files)
{
    if (file.StartsWith("."))
        continue;
    if (file.EndsWith(".csx"))
        continue;
    if (file.Contains(".git"))
        continue;
    if (file.Contains(".gradle"))
        continue;
    if (file.Contains("build"))
        continue;


    var fileContent = File.ReadAllText(file);
    var oldFile = file.Replace("\\","/");
    var newFile = oldFile;
    foreach (var replacement in replacements)
    {
        fileContent = fileContent.Replace(replacement.Old, replacement.New);
        newFile = newFile.Replace(replacement.Old.Replace(".","/"), replacement.New.Replace(".","/"));

        Console.WriteLine(replacement.Old.Replace(".","/")+" -> "+replacement.New.Replace(".","/"));
        
    }
    Console.WriteLine($"Moving \n\t< {oldFile} \n\t> {newFile}");
    File.Delete(oldFile);
    Directory.CreateDirectory(Path.GetDirectoryName(newFile));
    File.WriteAllText(newFile,fileContent);
}