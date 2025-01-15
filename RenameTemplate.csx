
public static List<string> FindAllFiles(string directoryPath)
{
    return Directory.GetFiles(directoryPath, "*.*", SearchOption.AllDirectories).ToList();
}

var replacements = new[]
{
    new { Old = "customcursor", New = "template" },
    new { Old = "Custom Cursor", New = "Template" },
    new { Old = "CustomCursor", New = "TempLate" },
    new { Old = "io.github.jumperonjava.customcursor", New = "io.github.example" }
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

    var fileContent = File.ReadAllText(file);
    var newFile = file;
    foreach (var replacement in replacements)
    {
        fileContent = fileContent.Replace(replacement.Old, replacement.New);
        newFile = newFile.Replace(replacement.Old.Replace(".","/"), replacement.New.Replace(".","/"));
    }
    File.Delete(file);
    File.WriteAllText(newFile,fileContent);
}